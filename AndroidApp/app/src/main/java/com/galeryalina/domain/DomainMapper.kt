package com.galeryalina.domain

import com.example.spacex.data.response.AuthorsResult
import com.example.spacex.data.response.PictureResult
import com.galeryalina.data.AuthorsEntity
import com.galeryalina.data.PictureEntity
import com.galeryalina.domain.model.Author
import com.galeryalina.domain.model.Picture


fun PictureResult.mapToDomain() = Picture(
    id = id,
    authorId = authorId,
    name = name,
    detail = detail,
    imageUrl = imageUrl,
    price = price,
    isUnique = isUnique,
    tagline = tagline,
    dateAdded = dateAdded
)

fun PictureResult.mapToEntity() = PictureEntity(
    id = id,
    authorId = authorId,
    name = name,
    detail = detail,
    imageUrl = name,
    price = price,
    isUnique = isUnique,
    tagline = tagline,
    dateAdded = dateAdded
)


fun AuthorsResult.mapToEntity() = AuthorsEntity(
    id = id,
    name = name,
    story = story,
    photoUrl = imageUrl,
    dateOfBirth = dateOfBirth
)

fun AuthorsEntity.mapToDomain() = Author(
    id = id,
    name = name,
    story = story,
    photoUrl = photoUrl,
    dateOfBirth = dateOfBirth,
    pictureIds = picturesIds
)
