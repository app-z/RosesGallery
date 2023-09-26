package com.galeryalina.ui.authors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galeryalina.data.Author
import com.galeryalina.data.common.ResponseResult
import com.galeryalina.domain.usecase.GetGalleryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class AuthorsViewModel @Inject constructor(
    private var getGalleryUseCase: GetGalleryUseCase
) : ViewModel() {
    private val _authors = MutableSharedFlow<ResponseResult<List<Author>>>()
    val authors = _authors.asSharedFlow()


    fun requestAuthors() {
        viewModelScope.launch (Dispatchers.IO){
            getGalleryUseCase.getAuthors().collect{
                _authors.emit(it)
            }
        }
    }
}
