package com.galeryalina.data.common

import com.example.spacex.data.common.DataSourceException
import com.galeryalina.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart

/** extension function for Flow Class to emit loading state before the flow starts */
fun <T> Flow<ResponseResult<T>>.onFlowStarts() = onStart { emit(ResponseResult.Loading) }.catch { e: Throwable ->
    e.printStackTrace()
    emit(ResponseResult.Error(DataSourceException.Unexpected(R.string.error_client_unexpected_message)))
}
