package com.galeryalina.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galeryalina.data.Picture
import com.galeryalina.data.common.ResponseResult
import com.galeryalina.domain.usecase.GetGalleryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
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

    fun requestPictures() {
        viewModelScope.launch {
            getGalleryUseCase.getAllPictures().collect{
                _pictures.emit(it)
            }
        }
    }
}
