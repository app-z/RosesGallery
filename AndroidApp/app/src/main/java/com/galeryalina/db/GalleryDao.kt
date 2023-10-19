package com.galeryalina.db

import androidx.room.*
import com.galeryalina.data.AuthorsEntity
import com.galeryalina.data.PictureEntity
import java.util.*

@Dao
interface GalleryDao {

    @Query("SELECT * FROM Pictures")
    fun getAllPictures(): List<PictureEntity>

    @Query("SELECT * FROM Pictures WHERE author_id = :authorId")
    fun getPicturesByAuthor(authorId: Int): List<PictureEntity>

    @Query("SELECT * FROM Pictures WHERE id = :pictureId")
    fun getPicturesById(pictureId: Int): PictureEntity

    @Query("SELECT * FROM Authors WHERE id = :autorId")
    fun getAuthorById(autorId: Int): AuthorsEntity

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
