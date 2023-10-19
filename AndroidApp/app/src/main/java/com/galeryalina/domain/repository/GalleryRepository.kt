package com.galeryalina.domain.repository

import com.galeryalina.data.Author
import com.galeryalina.data.Picture
import com.galeryalina.data.common.ResponseResult
import kotlinx.coroutines.flow.Flow

interface GalleryRepository {
    fun getAllPictures(): Flow<ResponseResult<List<Picture>>>
    fun getPicturesById(pictureId: Int): Flow<ResponseResult<Picture?>>
    fun getPicturesByAuthor(authorId: Int): Flow<ResponseResult<List<Picture>>>
    fun getAuthors(): Flow<ResponseResult<List<Author>>>
}
