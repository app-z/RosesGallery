package com.galeryalina.domain.model

import androidx.compose.runtime.Immutable
import com.example.spacex.data.response.AuthorsResult
import java.util.Date

@Immutable
data class Author(
    val id: Long,
    val name: String,
    val story: String?,
    val photoUrl: String?,
    val pictureIds: List<Long>?,
    val dateOfBirth: Date?
)

fun AuthorsResult.mapToDomain() = Author(
    id = id,
    name = name,
    story = story,
    photoUrl = imageUrl,
    dateOfBirth = dateOfBirth,
    pictureIds = pictureIds
)
