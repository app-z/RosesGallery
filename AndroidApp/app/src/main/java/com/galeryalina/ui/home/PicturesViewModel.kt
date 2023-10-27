package com.galeryalina.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galeryalina.data.common.ResponseResult
import com.galeryalina.domain.model.Picture
import com.galeryalina.domain.usecase.GetGalleryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PicturesViewModel @Inject constructor(
    private var getGalleryUseCase: GetGalleryUseCase
) : ViewModel() {

    private val _pictures = MutableStateFlow<ResponseResult<List<Picture>>>(ResponseResult.Loading)

    val pictures = _pictures.asStateFlow()

    fun requestPictures() {
        viewModelScope.launch {
            getGalleryUseCase.getAllPictures().collect{
                _pictures.emit(it)
            }
        }
    }
}
