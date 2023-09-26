package com.galeryalina.data

import com.example.spacex.data.response.AuthorsResult
import com.example.spacex.data.response.PictureResult


fun PictureResult.mapToDomain() = Picture(
    id = id,
    authorId = authorId,
    name = name,
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
    imageUrl = name,
    price = price,
    isUnique = isUnique,
    tagline = tagline,
    dateAdded = dateAdded
)


fun PictureEntity.mapToDomain() = Picture(
    id = id,
    authorId = authorId,
    name = name,
    imageUrl = imageUrl,
    price = price,
    isUnique = isUnique,
    tagline = tagline,
    dateAdded = dateAdded
)

fun AuthorsResult.mapToDomain() = Author(
    id = id,
    name = name,
    photoUrl = imageUrl,
    dateOfBirth = dateOfBirth,
    pictureIds = pictureIds
)


fun AuthorsResult.mapToEntity() = AuthorsEntity(
    id = id,
    name = name,
    photoUrl = imageUrl,
    dateOfBirth = dateOfBirth
)

fun AuthorsEntity.mapToDomain() = Author(
    id = id,
    name = name,
    photoUrl = photoUrl,
    dateOfBirth = dateOfBirth,
    pictureIds = picturesIds
)
