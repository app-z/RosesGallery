package com.galeryalina.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.galeryalina.ui.theme.ComposeGalleryAppTheme
import com.galeryalina.R
import com.galeryalina.data.Picture


@Composable
fun PictureCardList(pictureItems: List<Picture>, onClicker: (Int) -> Unit) {
    Column(modifier = Modifier
        .fillMaxHeight()) {

        LazyVerticalGrid(modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(4.dp),
            columns = GridCells.Fixed(2), content = {
                items(items = pictureItems, key = { item: Picture ->  item.id.toString() }) {
                        item ->
                    PictureCard(item, onClicker)
                }
            })
    }
}


@Composable
fun PictureCard(pictureItem: Picture, onClicker: (Int) -> (Unit)) {
    Card(modifier = Modifier
        .padding(4.dp).clickable{
            onClicker(pictureItem.id.toInt())
        },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(30.dp),) {

        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                maxLines = 1,
                text = pictureItem.name,
                style = MaterialTheme.typography.titleSmall
            )
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            AsyncImage(
                placeholder = rememberVectorPainter(Icons.Filled.Image),
                model = pictureItem.imageUrl,
                //imageVector = Icons.Filled.Rocket,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.size(150.dp)
            )
        }

        Spacer(modifier = Modifier
            .height(1.dp))

        Row(
            modifier = Modifier
                .wrapContentHeight()
                .padding(8.dp)
        ) {
            val price = LocalContext.current.getString(R.string.price_template, pictureItem.price)
            Text(
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                text = price,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

fun itemClick_(itemId: Int){}

@Preview
@Composable
fun PreviewPictures() {
    ComposeGalleryAppTheme {
        val listPict = listOf(
            Picture(id = 1, authorId = 2, "Pic1", null,"", 10000),
            Picture(id = 2, authorId = 3, "Pic2", null ,"", 20000))

        PictureCardList(listPict, ::itemClick_)
    }
}



