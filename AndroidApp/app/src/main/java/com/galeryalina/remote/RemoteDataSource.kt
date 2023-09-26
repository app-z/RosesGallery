package com.galeryalina.remote

import com.example.spacex.data.response.AuthorsResult
import com.galeryalina.data.common.ResponseResult
import com.example.spacex.data.response.PictureResult

interface RemoteDataSource {
    suspend fun getPictures(): ResponseResult<List<PictureResult>>
    suspend fun getAuthors(): ResponseResult<List<AuthorsResult>>
}
