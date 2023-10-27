package com.galeryalina.domain.model

import android.util.Size
import androidx.compose.runtime.Immutable
import com.galeryalina.data.PictureEntity
import java.util.*

@Immutable
data class Picture(
    val id: Long,
    val authorId: Long,
    val name: String,
    val detail: String?,
    val imageUrl: String,
    val price: Long,
    val isUnique: Boolean = true,
    val size: Size = Size(0, 0),
    val tagline: String = "",
    val tags: Set<String> = emptySet(),
    val dateAdded: Date? = null
)

fun PictureEntity.mapToDomain() = Picture(
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
