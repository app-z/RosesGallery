package com.galeryalina.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galeryalina.data.Picture
import com.galeryalina.data.common.ResponseResult
import com.galeryalina.domain.usecase.GetGalleryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PictureDetailViewModel @Inject constructor(
    private var getGalleryUseCase: GetGalleryUseCase
) : ViewModel() {

    private val _picture = MutableStateFlow<ResponseResult<Picture?>>(ResponseResult.Loading)
    val picture = _picture.asStateFlow()


    fun requestPictureById(pictureId: Int) {
        viewModelScope.launch {
            getGalleryUseCase.getPictureById(pictureId).collect{
                _picture.emit(it)
            }
        }
    }



}