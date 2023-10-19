/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.galeryalina.data

import android.os.Parcelable
import android.util.Size
import androidx.compose.runtime.Immutable
import androidx.versionedparcelable.ParcelField
import kotlinx.parcelize.Parcelize
import java.util.Date

@Immutable
//@Parcelize
data class Picture(
    val id: Long,
    val authorId: Long,
    val name: String,
    val imageUrl: String,
    val price: Long,
    val isUnique: Boolean = true,
    val size: Size = Size(0, 0),
    val tagline: String = "",
    val tags: Set<String> = emptySet(),
    val dateAdded: Date? = null
)
    //: Parcelable

@Immutable
data class Author(
    val id: Long,
    val name: String,
    val photoUrl: String?,
    val pictureIds: List<Long>?,
    val dateOfBirth: Date?
)

/**
 * Static data
 */

const val BASE_URL = "https://raw.githubusercontent.com/app-z/RosesGallery/main/server/"

const val AUTHORS_URL = "feed_authors.json"
const val PICTURES_URL = "feed_pictures.json"

val authors = listOf<AuthorsEntity>(
    AuthorsEntity(
        id = 1L,
        name = "Petunin",
        photoUrl = "",
        dateOfBirth = null,
        picturesIds = listOf<Long>(1, 2, 3, 4, 5)
    ),
    AuthorsEntity(
        id = 2L,
        name = "Author 2",
        photoUrl = "",
        dateOfBirth = null,
        picturesIds = listOf<Long>(6)
    ),
    AuthorsEntity(
        id = 3L,
        name = "Author 3",
        photoUrl = "",
        dateOfBirth = null,
        picturesIds = listOf<Long>(7)
    ),
    AuthorsEntity(
        id = 4L,
        name = "Author 4",
        photoUrl = "",
        dateOfBirth = null,
        picturesIds = listOf<Long>(7)
    ),

    )

val pictures = listOf<PictureEntity>(
    PictureEntity(
        id = 1L,
        authorId = 1,
        name = "Картина 1",
        tagline = "#Модерн",
        imageUrl = "$BASE_URL/images/petunin_paint1.jpeg",
        price = 299
    ),
    PictureEntity(
        id = 2L,
        authorId = 1,
        name = "Картина 2",
        tagline = "#Модерн",
        imageUrl = "$BASE_URL/images/petunin_paint2.jpeg",
        price = 299
    ),
    PictureEntity(
        id = 3L,
        authorId = 1,
        name = "Картина 3",
        tagline = "#Модерн",
        imageUrl = "$BASE_URL/images/petunin_paint3.jpeg",
        price = 299
    ),
    PictureEntity(
        id = 4L,
        authorId = 1,
        name = "Картина 4",
        tagline = "#Лента",
        imageUrl = "$BASE_URL/images/petunin_paint4.jpeg",
        isUnique = true,
        price = 400000
    ),
    PictureEntity(
        id = 5L,
        authorId = 1,
        name = "Картина 5",
        tagline = "#Море",
        imageUrl = "$BASE_URL/images/petunin_paint5.jpeg",
        price = 499
    ),
    PictureEntity(
        id = 6L,
        authorId = 2,
        name = "Картина 6",
        tagline = "#Модерн",
        imageUrl = "$BASE_URL/images/modern1.jpg",
        price = 299
    ),
    PictureEntity(
        id = 7L,
        authorId = 2,
        name = "Картина 7",
        tagline = "#Холст #Модерн",
        imageUrl = "$BASE_URL/images/modern2.jpg",
        price = 1299
    ),
    PictureEntity(
        id = 8L,
        authorId = 2,
        name = "Картина 8",
        tagline = "Модерн",
        imageUrl = "$BASE_URL/images/modern3.jpg",
        price = 299
    ),
    PictureEntity(
        id = 9L,
        authorId = 2,
        name = "Картина 9",
        tagline = "#Модерн",
        imageUrl = "$BASE_URL/images/modern4.jpg",
        price = 549
    ),
    PictureEntity(
        id = 10L,
        authorId = 2,
        name = "Картина 10",
        tagline = "#Модерн",
        imageUrl = "$BASE_URL/images/modern5.jpg",
        price = 299
    ),
    PictureEntity(
        id = 11L,
        authorId = 3,
        name = "Картина 10",
        tagline = "#Примитивизм",
        imageUrl = "$BASE_URL/images/prim1.jpg",
        price = 299
    ),
    PictureEntity(
        id = 12L,
        authorId = 3,
        name = "Картина 12",
        tagline = "#Примитивизм",
        imageUrl = "$BASE_URL/images/prim2.jpg",
        price = 299
    ),
    PictureEntity(
        id = 13L,
        authorId = 3,
        name = "Картина 13",
        tagline = "#Примитивизм",
        imageUrl = "$BASE_URL/images/prim3.jpg",
        price = 299
    ),
    PictureEntity(
        id = 14L,
        authorId = 4,
        name = "Картина 14",
        tagline = "#Примитивизм",
        imageUrl = "$BASE_URL/images/prim4.jpg",
        price = 2990
    ),
    PictureEntity(
        id = 15L,
        authorId = 4,
        name = "Картина 15",
        tagline = "#Примитивизм",
        imageUrl = "$BASE_URL/images/prim5.jpg",
        price = 299
    )
)
