package com.galeryalina.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Pictures")
data class PictureEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "author_id") val authorId: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "price") val price: Long,
    @ColumnInfo(name = "is_unique") var isUnique: Boolean = true,
//    @ColumnInfo(name = "size") var size: Size,
    @ColumnInfo(name = "tagline") var tagline: String,
    @ColumnInfo(name = "date_added") var dateAdded: Date? = null
)

@Entity(tableName = "Authors")
data class AuthorsEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "photo_url") val photoUrl: String? = null,
    @ColumnInfo(name = "date_of_birth") var dateOfBirth: Date? = null,
    @ColumnInfo(name = "pictures_ids") var picturesIds: List<Long>? = null
)
