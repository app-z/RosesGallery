package com.galeryalina.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.galeryalina.data.AuthorsEntity
import com.galeryalina.data.PictureEntity
import com.galeryalina.data.authors
import com.galeryalina.data.pictures
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [PictureEntity::class, AuthorsEntity::class], version = 3)
@TypeConverters(Converters::class)
abstract class GaleryDatabase : RoomDatabase() {
    abstract fun dao(): GalleryDao

    companion object {
        @Volatile
        private var INSTANCE: GaleryDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): GaleryDatabase = buildDatabase(context, scope)

        private fun buildDatabase(appContext: Context, scope: CoroutineScope): GaleryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    appContext, GaleryDatabase::class.java, "GalleryDatabase.db"
                ).fallbackToDestructiveMigration().addCallback(ItemCallback(scope)).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class ItemCallback(val scope: CoroutineScope) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                INSTANCE?.let {
                    scope.launch {
                        it.dao().insertAllPictures(pictures)
                        it.dao().insertAllAuthors(authors)
                    }
                }
            }

            override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                super.onDestructiveMigration(db)
                INSTANCE?.let {
                    scope.launch {
                        it.dao().cleanAuthors()
                        it.dao().cleanPictures()
                        it.dao().insertAllPictures(pictures)
                        it.dao().insertAllAuthors(authors)
                    }
                }
            }
        }
    }
}
