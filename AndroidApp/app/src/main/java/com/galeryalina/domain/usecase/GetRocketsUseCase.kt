package com.galeryalina.domain.usecase

import com.galeryalina.domain.repository.GalleryRepository
import javax.inject.Inject

class GetGalleryUseCase @Inject constructor(private val galleryRepository: GalleryRepository) {
    fun getPicturesByAuthor(authorId: Int) = galleryRepository.getPicturesByAuthor(authorId)
    fun getAllPictures() = galleryRepository.getAllPictures()
    fun getPictureById(pictureId: Int) = galleryRepository.getPicturesById(pictureId)
    fun getAuthors() = galleryRepository.getAuthors()
}
