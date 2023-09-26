package com.galeryalina.remote

import com.example.spacex.data.common.DataSourceException
import com.example.spacex.data.response.AuthorsResult
import com.galeryalina.data.common.RequestErrorHandler
import com.galeryalina.data.common.ResponseResult
import com.example.spacex.data.response.PictureResult
import com.galeryalina.Constants
import com.galeryalina.R

class RemoteDataSourceImpl(private val apiServices: ApiServices) : RemoteDataSource {

    override suspend fun getPictures(): ResponseResult<List<PictureResult>> {
        return try {
            val result = apiServices.getPictures(Constants.DB_KEY)
            if (result.isSuccessful) {
                result.body()?.let {
                    if (it.results.isNotEmpty()) {
                        ResponseResult.Success(it.results)
                    } else {
                        ResponseResult.Error(DataSourceException.Server(R.string.no_results_found))
                    }
                } ?: run {
                    ResponseResult.Error(
                        DataSourceException.Unexpected(R.string.error_unexpected_message)
                    )
                }
            } else {
                ResponseResult.Error(DataSourceException.Server(R.string.error_server_unexpected_message))
            }
        } catch (e: Exception) {
            ResponseResult.Error(RequestErrorHandler.getRequestError(e))
        }
    }

    override suspend fun getAuthors(): ResponseResult<List<AuthorsResult>> {
            return try {
                val result = apiServices.getAuthors(Constants.DB_KEY)
                if (result.isSuccessful) {
                    result.body()?.let {
                        if (it.results.isNotEmpty()) {
                            ResponseResult.Success(it.results)
                        } else {
                            ResponseResult.Error(DataSourceException.Server(R.string.no_results_found))
                        }
                    } ?: run {
                        ResponseResult.Error(
                            DataSourceException.Unexpected(R.string.error_unexpected_message)
                        )
                    }
                } else {
                    ResponseResult.Error(DataSourceException.Server(R.string.error_server_unexpected_message))
                }
            } catch (e: Exception) {
                ResponseResult.Error(RequestErrorHandler.getRequestError(e))
            }
    }
}
