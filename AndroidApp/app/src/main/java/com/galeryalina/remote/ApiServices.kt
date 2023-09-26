package com.galeryalina.remote

import com.example.spacex.data.response.AuthorsResult
import com.example.spacex.data.response.PictureResult
import com.galeryalina.data.response.BaseResponse
import com.galeryalina.Constants

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiServices {
    @GET(Constants.PICTURES)
    suspend fun getPictures(@Query("api_key") apiKey: String): Response<BaseResponse<PictureResult>>

    @GET(Constants.AUTHORS)
    suspend fun getAuthors(@Query("api_key") apiKey: String): Response<BaseResponse<AuthorsResult>>
}
