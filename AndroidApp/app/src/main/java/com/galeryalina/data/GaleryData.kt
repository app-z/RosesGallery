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

import android.util.Size
import androidx.compose.runtime.Immutable
import java.util.Date

@Immutable
//@Parcelize
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
    //: Parcelable

@Immutable
data class Author(
    val id: Long,
    val name: String,
    val story: String?,
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
        story = null,
        photoUrl = "",
        dateOfBirth = null,
        picturesIds = listOf<Long>(1, 2, 3, 4, 5)
    ),
    AuthorsEntity(
        id = 2L,
        name = "Author 2",
        story = null,
        photoUrl = "",
        dateOfBirth = null,
        picturesIds = listOf<Long>(6)
    ),
    AuthorsEntity(
        id = 3L,
        name = "Author 3",
        story = null,
        photoUrl = "",
        dateOfBirth = null,
        picturesIds = listOf<Long>(7)
    ),
    AuthorsEntity(
        id = 4L,
        name = "Author 4",
        story = null,
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
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].\n" +
                "\n" +
                "Поэтому под картиной подразумевают произведение станкóвого искусства, обычно живописи. Для других разновидностей изобразительного творчества, например графики, используют иные названия: рисунок, графический лист, эстамп. Произведения декоративного искусства также в строгом смысле слова не следует называть картинами, поскольку декоративные росписи обретают художественный смысл только во взаимосвязи с окружающей средой (архитектурой, плоскостью декорирования, формой изделия). Книжная миниатюра, иллюстрация связаны с форматом страницы и книгой как «целостным организмом» (определение В. А. Фаворского). Подготовительные эскизы, этюды) в отличие от законченного произведения также не являются картинами (допускается лишь разговорное: «картинка»). Распространённое мнение о том, что картина должна представлять собой наглядное, убедительное и даже иллюзорное, изображение, также неверно. Картина может быть и абстрактной, и даже незавершённой, но обязательно замкнутой «самой в себе».",
        tagline = "#Модерн",
        imageUrl = "$BASE_URL/images/petunin_paint1.jpeg",
        price = 299
    ),
    PictureEntity(
        id = 2L,
        authorId = 1,
        name = "Картина 2",
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].\n" +
                "\n" +
                "Поэтому под картиной подразумевают произведение станкóвого искусства, обычно живописи. Для других разновидностей изобразительного творчества, например графики, используют иные названия: рисунок, графический лист, эстамп. Произведения декоративного искусства также в строгом смысле слова не следует называть картинами, поскольку декоративные росписи обретают художественный смысл только во взаимосвязи с окружающей средой (архитектурой, плоскостью декорирования, формой изделия). Книжная миниатюра, иллюстрация связаны с форматом страницы и книгой как «целостным организмом» (определение В. А. Фаворского). Подготовительные эскизы, этюды) в отличие от законченного произведения также не являются картинами (допускается лишь разговорное: «картинка»). Распространённое мнение о том, что картина должна представлять собой наглядное, убедительное и даже иллюзорное, изображение, также неверно. Картина может быть и абстрактной, и даже незавершённой, но обязательно замкнутой «самой в себе».\n" +
                "\n" +
                "В истории искусства выработано понятие «изображение картинного типа», предполагающее замкнутую композицию, в прямоугольной раме, обеспечивающей функцию отграничения изображения от окружающего пространства. Именно поэтому наилучшие условия восприятия картины обеспечивает гладкая и ровная, нейтральная по цвету стена музея или выставочного зала. Отсюда также возникает проблема обособления понятий «картина» (станковое изображение) и «икона». Понятия «изображение» и «икона» имеют общую этимологию и корневую основу (слово «образ»). Они относятся к одному виду изобразительного искусства, но имеют разные функции, которые исторически стали причиной иконографических, композиционных и стилевых особенностей. Эта проблема соприкасается с проблемой специфики жанров изобразительного искусства.\n" +
                "\n" +
                "Изображения картинного типа характерны для западноевропейского классического искусства, поскольку живописная картина как произведение относительно самостоятельного станкового творчества отделилась от архитектуры и художественных ремёсел только в эпоху итальянского Возрождения, хотя история живописной картины на досках (пинаках) начиналась ещё в Античности. На Востоке морфологические процессы в искусстве протекали иначе. Так, например, в Китае живописцы работали на свитках, в Японии расписывали ширмы и веера. Картина — европейское понятие.\n" +
                "\n" +
                "Живописная картина как материальный объект (деревянная доска, холст, картон), ограниченный профилированной рамой, на поверхности которого создаётся особое — концептуальное — изобразительное пространство (независимо от того, имеет оно иллюзорные свойства или нет), представляет собой, по справедливому определению С. М. Даниэля, «невозможный, парадоксальный объект», определяемый дуализмом категорий «быть» и «казаться»[3]. С физической точки зрения картина является двумерной поверхностью с нанесёнными на неё красками, а с художественной — особым миром, вмещающим в себя пространство и предметы, истинные физические размеры которых много больше изображённых на картине. В изобразительном пространстве «картинного типа» могут соединяться предметы, не сочетаемые в действительности; время может быть остановлено или пущено в обратном направлении[4].\n" +
                "\n" +
                "Британский исследователь психологии зрительного восприятия Р. Грегори формулировал эту мысль следующим образом: «Всякий предмет является самим собой, и только картины имеют двойную природу, и поэтому они — единственный в своём роде класс парадоксальных объектов… Картины парадоксальны. Никакой объект не может находиться в двух местах одновременно; никакой объект не может быть одновременно двумерным и трёхмерным. А картины мы видим именно так. Картина имеет совершенно определённый размер, и в то же время она показывает истинную величину человеческого лица, здания или корабля. Картины — невозможные объекты»[5].\n" +
                "\n" +
                "В искусстве авангарда, модернизма и постмодернизма XX века, в противопоставление традиционному картинному восприятию формировались приёмы «клипового мышления», основанного не на композиционном, а на комбинаторном принципе формосложения, чередования цитат, обрывков фраз и осколков форм. В этом смысле история искусства показывает, что изображение картинного типа присуще классическим эпохам, когда сознание человека обладает свойствами целостности и гармоничности отношений с окружающим миром[6][7].\n" +
                "\n" +
                "Картина в драме, опере, балете, в киноискусстве — законченная часть акта или произведения, ограниченная неизменным пространством действия. При постановке на сцене, как правило, показывается без смены декораций[8]. На сленге кинематографистов картиной называется кинофильм.\n" +
                "\n" +
                "Репродукция или копия оригинала может также называться картиной, если в соответствующем контексте неважно, копия это или оригинальное произведение. Например, «в коридоре висело несколько картин».\n" +
                "\n" +
                "Способность человека реагировать на отсутствующие, воображаемые ситуации, представленные в картинах, является важным этапом в развитии абстрактного мышления. Иоганн-Вольфганг Гёте писал: «Картины не просто раскрашенный холст, они воздействуют на чувства и мысли, оставляют след в душе, пробуждают предчувствия».",
        tagline = "#Модерн",
        imageUrl = "$BASE_URL/images/petunin_paint2.jpeg",
        price = 299
    ),
    PictureEntity(
        id = 3L,
        authorId = 1,
        name = "Картина 3",
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].",
        tagline = "#Модерн",
        imageUrl = "$BASE_URL/images/petunin_paint3.jpeg",
        price = 299
    ),
    PictureEntity(
        id = 4L,
        authorId = 1,
        name = "Картина 4",
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].",
        tagline = "#Лента",
        imageUrl = "$BASE_URL/images/petunin_paint4.jpeg",
        isUnique = true,
        price = 400000
    ),
    PictureEntity(
        id = 5L,
        authorId = 1,
        name = "Картина 5",
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].",
        tagline = "#Море",
        imageUrl = "$BASE_URL/images/petunin_paint5.jpeg",
        price = 499
    ),
    PictureEntity(
        id = 6L,
        authorId = 2,
        name = "Картина 6",
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].",
        tagline = "#Модерн",
        imageUrl = "$BASE_URL/images/modern1.jpg",
        price = 299
    ),
    PictureEntity(
        id = 7L,
        authorId = 2,
        name = "Картина 7",
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].",
        tagline = "#Холст #Модерн",
        imageUrl = "$BASE_URL/images/modern2.jpg",
        price = 1299
    ),
    PictureEntity(
        id = 8L,
        authorId = 2,
        name = "Картина 8",
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].",
        tagline = "Модерн",
        imageUrl = "$BASE_URL/images/modern3.jpg",
        price = 299
    ),
    PictureEntity(
        id = 9L,
        authorId = 2,
        name = "Картина 9",
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].",
        tagline = "#Модерн",
        imageUrl = "$BASE_URL/images/modern4.jpg",
        price = 549
    ),
    PictureEntity(
        id = 10L,
        authorId = 2,
        name = "Картина 10",
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].",
        tagline = "#Модерн",
        imageUrl = "$BASE_URL/images/modern5.jpg",
        price = 299
    ),
    PictureEntity(
        id = 11L,
        authorId = 3,
        name = "Картина 10",
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].",
        tagline = "#Примитивизм",
        imageUrl = "$BASE_URL/images/prim1.jpg",
        price = 299
    ),
    PictureEntity(
        id = 12L,
        authorId = 3,
        name = "Картина 12",
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].",
        tagline = "#Примитивизм",
        imageUrl = "$BASE_URL/images/prim2.jpg",
        price = 299
    ),
    PictureEntity(
        id = 13L,
        authorId = 3,
        name = "Картина 13",
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].",
        tagline = "#Примитивизм",
        imageUrl = "$BASE_URL/images/prim3.jpg",
        price = 299
    ),
    PictureEntity(
        id = 14L,
        authorId = 4,
        name = "Картина 14",
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].",
        tagline = "#Примитивизм",
        imageUrl = "$BASE_URL/images/prim4.jpg",
        price = 2990
    ),
    PictureEntity(
        id = 15L,
        authorId = 4,
        name = "Картина 15",
        detail = "Картина в живописи (итал. cartina — тонкая, красивая бумага, от итал. carta — бумага) — произведение изобразительного искусства «относительно ограниченное от окружающей среды и предполагающее сосредоточенное, длительное восприятие с одной фиксированной точки зрения»[1]. Отсюда вторичные значения слова в эстетическом аспекте: «картинка, картинный» в смысле «прекрасный вид природы», красивый пейзаж; «картиниться — рисоваться, хорошиться, выставлять себя напоказ»[2].",
        tagline = "#Примитивизм",
        imageUrl = "$BASE_URL/images/prim5.jpg",
        price = 299
    )
)
