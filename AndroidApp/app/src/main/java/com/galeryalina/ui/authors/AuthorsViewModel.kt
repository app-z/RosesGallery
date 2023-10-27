package com.galeryalina.ui.authors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galeryalina.data.common.ResponseResult
import com.galeryalina.domain.model.Author
import com.galeryalina.domain.usecase.GetGalleryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorsViewModel @Inject constructor(
    private var getGalleryUseCase: GetGalleryUseCase
) : ViewModel() {
    private val _authors = MutableStateFlow<ResponseResult<List<Author>>>(ResponseResult.Loading)
    val authors = _authors.asStateFlow()


    fun requestAuthors() {
        viewModelScope.launch (Dispatchers.IO){
            getGalleryUseCase.getAuthors().collect{
                _authors.emit(it)
            }
        }
    }
}
