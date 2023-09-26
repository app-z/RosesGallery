package com.galeryalina.db

import androidx.room.*
import com.galeryalina.data.AuthorsEntity
import com.galeryalina.data.PictureEntity
import java.util.*

@Dao
interface GaleryDao {

    @Query("SELECT * FROM Pictures")
    fun getAllPictures(): List<PictureEntity>

    @Query("SELECT * FROM Pictures WHERE author_id = :authorId")
    fun getPicturesByAuthor(authorId: Int): List<PictureEntity>

    @Query("SELECT * FROM Authors")
    fun getAllAuthors(): List<AuthorsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPictures(pictures: List<PictureEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAuthors(authors: List<AuthorsEntity>)

    @Query("DELETE FROM Authors")
    fun cleanAuthors()

    @Query("DELETE FROM Pictures")
    fun cleanPictures()
}
