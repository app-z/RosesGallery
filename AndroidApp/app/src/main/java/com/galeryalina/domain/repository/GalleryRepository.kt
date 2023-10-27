package com.galeryalina.domain.repository

import com.galeryalina.data.common.ResponseResult
import com.galeryalina.domain.model.Author
import com.galeryalina.domain.model.Picture
import kotlinx.coroutines.flow.Flow

interface GalleryRepository {
    fun getAllPictures(): Flow<ResponseResult<List<Picture>>>
    fun getPicturesById(pictureId: Int): Flow<ResponseResult<Picture?>>
    fun getPicturesByAuthor(authorId: Int): Flow<ResponseResult<List<Picture>>>
    fun getAuthors(): Flow<ResponseResult<List<Author>>>
}
