package com.example.spacex.data.response

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Keep
data class PictureResult(
    @SerializedName("id") val id: Long,
    @SerializedName("author_id") val authorId: Long,
    @SerializedName("name") val name: String,
    @SerializedName("detail") val detail: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("price") val price: Long,
    @SerializedName("is_unique") var isUnique: Boolean = true,
//    @SerializedName("size") var size: Size,
    @SerializedName("tagline") var tagline: String,
    @SerializedName("date_added") var dateAdded: Date? = null
)

@Keep
data class AuthorsResult(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("story") val story: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("date_of_birth") val dateOfBirth: Date? = null,
    @SerializedName("picture_ids") val pictureIds: List<Long>?

)

