package com.galeryalina.local

import com.galeryalina.data.AuthorsEntity
import com.galeryalina.data.PictureEntity
import com.galeryalina.db.GaleryDao

class LocalDataSource constructor(private val galeryDao: GaleryDao) {

    fun getAllPictures(): List<PictureEntity> = galeryDao.getAllPictures()

    fun getPicturesByAuthor(authorId: Int): List<PictureEntity> = galeryDao.getPicturesByAuthor(authorId)

    fun getAllAuthors(): List<AuthorsEntity> = galeryDao.getAllAuthors()

    fun insertPicture(pictureEntity: List<PictureEntity>) = galeryDao.insertAllPictures(pictureEntity)

    fun insertAuthor(authorsEntity: List<AuthorsEntity>) { galeryDao.insertAllAuthors(authorsEntity)}

}
