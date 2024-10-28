package com.shmulik.newsiron.ui.widget

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.shmulik.domain.entities.NewsEntity
import com.shmulik.domain.entities.PlaceHolderColor
import com.shmulik.domain.entities.toColor

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    item: NewsEntity
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Card(
            modifier = modifier.height(200.dp)
        ) {
            Log.d("Shmulik", "NewsCard: ${item.imageUrl}")
            Box(modifier = Modifier.background(color = Color.Gray)) {
//                AsyncImage(
//                    modifier = Modifier.fillMaxSize(),
//                    contentScale = ContentScale.Crop,
//                    model = item.imageUrl,
//                    contentDescription = null
//                )
                SubcomposeAsyncImage(
                    model = item.imageUrl,
                    loading = { Placeholder(item.placeholderColor) },
                    error = { },
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(280.dp)
                        .fillMaxWidth(1f)
                )
            }

        }

        Text(text = "Rating  = ${item.rating.toString()}", color = Color.Black)

        Text(text = "Title  = ${item.title.toString()}", color = Color.Black)

        Text(text = "Description = ${item.description.toString()}", color = Color.Black)
    }

}

@Composable
private fun Placeholder(placeholderColor: PlaceHolderColor) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = placeholderColor.toColor())
    )
}

@Composable
@Preview
fun PreviewPinCard() {
    val item = NewsEntity(
        title = "Title",
        description = "Description",
        imageUrl = "https://images.unsplash.com/photo-1634170380000-7b3b3b3b3b3b",
        rating = 1,
        placeholderColor = PlaceHolderColor(1, 1, 1)

    )
    NewsCard(item = item)
}