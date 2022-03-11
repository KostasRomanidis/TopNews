package com.kroman.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kroman.presentation.models.ArticleItem
import com.kroman.presentation.models.SourceItem
import com.kroman.presentation.theme.Grey200
import com.kroman.presentation.theme.Grey600
import com.kroman.presentation.theme.Grey800

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val uiState by homeViewModel.uiState.collectAsState()
    when (uiState) {
        is HomeUIState.HasArticles -> ArticleList((uiState as HomeUIState.HasArticles).articles!!)
        is HomeUIState.NoArticles -> LoadingArticlesScreen()
    }
}

@Composable
fun ArticleList(articles: List<ArticleItem>) {
    LazyColumn(
        modifier = Modifier
            .background(Grey200)
            .fillMaxWidth()
            .padding(5.dp)
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(articles) { index, article ->
            if (index == 0) {
                FirstArticleCard(article = article)
            } else {
                ArticleCard(article = article) {
                }
            }
        }
    }
}

@Composable
fun ArticleCard(article: ArticleItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .background(Color.White)
            .shadow(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(top = 5.dp, bottom = 5.dp)
                .height(66.dp)
        ) {
            Spacer(modifier = Modifier.width(5.dp))
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(article.image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(64.dp)
                    .width(64.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(
                    text = article.title,
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    color = Grey800,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}

@Composable
fun FirstArticleCard(article: ArticleItem) {
    Card(
        modifier = Modifier.background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp)
                .background(Color.White)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(article.image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = article.title,
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 2.dp)
            )
        }
    }
}

@Composable
fun LoadingArticlesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
fun ArticleCardPreview() {
    val article = ArticleItem(
        title = "Teenage striker Josh Coburn nets extra-time winner for Middlesbrough to knock Tottenham out of FA Cup",
        description = "Middlesbrough 1 Tottenham 0 AET",
        content = "To our live coverage of Tuesday's FA Cup fifth round games - Peterborough vs Manchester City (7.15pm kick-off), Crystal Palace vs Stoke (7.30pm) and Middlesbrough vs Tottenham (7.55pm).\nWe will keep you up to date with the action from all three games... [2601 chars]",
        url = "https://www.telegraph.co.uk/football/2022/03/01/fa-cup-live-peterborough-vs-man-city-middlesbrough-vs-tottenham/",
        image = "https://www.telegraph.co.uk/content/dam/football/2022/03/01/TELEMMGLPICT000287905827_trans_NvBQzQNjv4BqfB-9o7Jl_5dxeDkgnjyCr0Q7EiYC2LyY4IabJiAvK-c.jpeg",
        publishedAt = "2022-03-01T22:22:00Z",
        source = SourceItem(
            name = "The Telegraph",
            url = "https://www.telegraph.co.uk"
        )
    )
    ArticleCard(article = article) {
    }
}

@Preview
@Composable
fun FirstArticleCardPreview() {
    val article = ArticleItem(
        title = "Teenage striker Josh Coburn nets extra-time winner for Middlesbrough to knock Tottenham out of FA Cup",
        description = "Middlesbrough 1 Tottenham 0 AET",
        content = "To our live coverage of Tuesday's FA Cup fifth round games - Peterborough vs Manchester City (7.15pm kick-off), Crystal Palace vs Stoke (7.30pm) and Middlesbrough vs Tottenham (7.55pm).\nWe will keep you up to date with the action from all three games... [2601 chars]",
        url = "https://www.telegraph.co.uk/football/2022/03/01/fa-cup-live-peterborough-vs-man-city-middlesbrough-vs-tottenham/",
        image = "https://www.telegraph.co.uk/content/dam/football/2022/03/01/TELEMMGLPICT000287905827_trans_NvBQzQNjv4BqfB-9o7Jl_5dxeDkgnjyCr0Q7EiYC2LyY4IabJiAvK-c.jpeg",
        publishedAt = "2022-03-01T22:22:00Z",
        source = SourceItem(
            name = "The Telegraph",
            url = "https://www.telegraph.co.uk"
        )
    )
    FirstArticleCard(article = article)
}

@Preview
@Composable
fun LoadingArticlesListPreview() {
    LoadingArticlesScreen()
}
