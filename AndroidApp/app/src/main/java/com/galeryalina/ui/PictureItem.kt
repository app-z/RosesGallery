package com.galeryalina.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.galeryalina.R
import com.galeryalina.data.Picture
import timber.log.Timber


interface RowClick {
    fun onClick(pictureId: Long)
}

@Composable
fun PictureItem_(picture: Picture, clicker: RowClick?) {
    Row(modifier = Modifier.padding(all = 8.dp).clickable{
        clicker?.onClick(picture.id)
    }) {
        Timber.d("imageUrl = ${picture.imageUrl}")
        AsyncImage(
            //painter = painterResource(R.drawable.pictire_boat_icon_24_dark),
            placeholder = painterResource(R.drawable.pictire_boat_icon_24_dark),
            model = picture.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .size(40.dp, 60.dp)
                .clip(RoundedCornerShape(percent = 10))
                //.aspectRatio(0.8F)
                .border(1.5.dp,
                    MaterialTheme.colorScheme.primary,
                    RoundedCornerShape(percent = 10))
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = picture.name,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(text = picture.tagline)
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    PictureItem_(picture =
    Picture(1,
        2, "Author",
        "http",
        10000,
        true),
            clicker = null
        )

}