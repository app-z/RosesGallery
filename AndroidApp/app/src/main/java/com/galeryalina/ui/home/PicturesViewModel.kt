package com.galeryalina.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galeryalina.data.Picture
import com.galeryalina.data.common.ResponseResult
import com.galeryalina.domain.usecase.GetGalleryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PicturesViewModel @Inject constructor(
    private var getGalleryUseCase: GetGalleryUseCase
) : ViewModel() {

    private val _pictures = MutableSharedFlow<ResponseResult<List<Picture>>>()
        .apply {
        viewModelScope.launch {
            getGalleryUseCase.getAllPictures().collect{
                emit(it)
            }
        }
    }

    val pictures = _pictures.asSharedFlow()

    fun requestPicture() {
        viewModelScope.launch {
            getGalleryUseCase.getAllPictures().collect{
                _pictures.emit(it)
            }
        }
    }

}
