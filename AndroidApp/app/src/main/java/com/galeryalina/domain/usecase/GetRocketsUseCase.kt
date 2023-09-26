package com.galeryalina.domain.usecase

import com.galeryalina.domain.repository.GalleryRepository
import javax.inject.Inject

class GetGalleryUseCase @Inject constructor(private val galleryRepository: GalleryRepository) {
    suspend fun getPicturesByAuthor(authorId: Int) = galleryRepository.getPicturesByAuthor(authorId)
    suspend fun getAllPictures() = galleryRepository.getAllPictures()
    suspend fun getAuthors() = galleryRepository.getAuthors()
}
