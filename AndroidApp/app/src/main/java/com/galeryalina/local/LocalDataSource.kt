package com.galeryalina.local

import com.galeryalina.data.AuthorsEntity
import com.galeryalina.data.PictureEntity
import com.galeryalina.db.GalleryDao

class LocalDataSource constructor(private val galleryDao: GalleryDao) {

    fun getAllPictures(): List<PictureEntity> = galleryDao.getAllPictures()

    fun getPicturesByAuthor(authorId: Int): List<PictureEntity> = galleryDao.getPicturesByAuthor(authorId)

    fun getPicturesById(pictureId: Int): PictureEntity = galleryDao.getPicturesById(pictureId)

    fun getAllAuthors(): List<AuthorsEntity> = galleryDao.getAllAuthors()

    fun insertPicture(pictureEntity: List<PictureEntity>) = galleryDao.insertAllPictures(pictureEntity)

    fun insertAuthor(authorsEntity: List<AuthorsEntity>) { galleryDao.insertAllAuthors(authorsEntity)}

}
