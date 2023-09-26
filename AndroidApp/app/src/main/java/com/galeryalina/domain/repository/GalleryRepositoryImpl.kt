package com.galeryalina.domain.repository

import com.galeryalina.data.Author
import com.galeryalina.local.LocalDataSource
import com.galeryalina.data.Picture
import com.galeryalina.data.common.ResponseResult
import com.galeryalina.data.common.onFlowStarts
import com.galeryalina.data.mapToDomain
import com.galeryalina.data.mapToEntity
import com.galeryalina.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

class GalleryRepositoryImpl constructor(
    private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource
) : GalleryRepository {

    override fun getPicturesByAuthor(authorId: Int): Flow<ResponseResult<List<Picture>>> {
        return flow {
            if (localDataSource.getPicturesByAuthor(authorId).isNotEmpty()) {
                Timber.d(">>>> RepositoryImpl : authorId = $authorId")
                emit(ResponseResult.Success(localDataSource.getPicturesByAuthor(authorId).map { it.mapToDomain() }))
            } else {
                remoteDataSource.getPictures().run {
                    when (this) {
                        is ResponseResult.Success -> {
                            localDataSource.insertPicture(response.map { it.mapToEntity() })
                            emit(ResponseResult.Success(response.map { it.mapToDomain() }))
                        }
                        is ResponseResult.Error -> {
                            emit(ResponseResult.Error(exception))
                        }
                        else -> {}
                    }
                }
            }
        }.flowOn(Dispatchers.IO).onFlowStarts()
    }

    override fun getAuthors(): Flow<ResponseResult<List<Author>>> {
        return flow {
            if (localDataSource.getAllAuthors().isNotEmpty()) {
                localDataSource.getAllAuthors().map {
                    it.mapToDomain()
                }
                emit(ResponseResult.Success(localDataSource.getAllAuthors().map { it.mapToDomain() }))
            } else {
                    remoteDataSource.getAuthors().run {
                    when (this) {
                        is ResponseResult.Success -> {
                            localDataSource.insertAuthor(response.map { it.mapToEntity() })
                            emit(ResponseResult.Success(response.map { it.mapToDomain() }))
                        }
                        is ResponseResult.Error -> {
                            emit(ResponseResult.Error(exception))
                        }
                        else -> {}
                    }
                }
            }
        }.flowOn(Dispatchers.IO).onFlowStarts()
    }

    override fun getAllPictures(): Flow<ResponseResult<List<Picture>>> {
        return flow {
            if (localDataSource.getAllPictures().isNotEmpty()) {
                Timber.d(">>>> RepositoryImpl : getAllPictures")
                emit(ResponseResult.Success(localDataSource.getAllPictures().map { it.mapToDomain() }))
            } else {
                remoteDataSource.getPictures().run {
                    when (this) {
                        is ResponseResult.Success -> {
                            localDataSource.insertPicture(response.map { it.mapToEntity() })
                            emit(ResponseResult.Success(response.map { it.mapToDomain() }))
                        }
                        is ResponseResult.Error -> {
                            emit(ResponseResult.Error(exception))
                        }
                        else -> {}
                    }
                }
            }
        }.flowOn(Dispatchers.IO).onFlowStarts()
    }
}
