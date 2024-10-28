package com.shmulik.newsiron.ui.page.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shmulik.domain.entities.NewsEntity
import com.shmulik.newsiron.ui.page.feed.FeedPageViewModel
import com.shmulik.newsiron.ui.widget.NewsCard
import com.shmulik.newsiron.ui.widget.SearchView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedPage(
    viewModel: FeedPageViewModel = hiltViewModel()
) {

    val feedNews = viewModel.news.collectAsState()
    var query: String by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Feed Page") }
            )

        }
    ) { padding ->


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ) {
            Column {
                SearchView {
                    query = it
                }

                Text(modifier = Modifier.clickable {
                    viewModel.onFilterClick(listOf(Filter.Title(query)))
                }, text = "Apply")


                FeedScreen(feedNews.value)
            }
        }

    }
}


@Composable
fun FeedScreen(
    news: List<NewsEntity>
) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(news.size) { index ->
            val item = news[index] ?: return@items
            NewsCard(item = item)
        }
    }
}