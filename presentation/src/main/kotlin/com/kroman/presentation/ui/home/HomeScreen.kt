package com.kroman.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.kroman.presentation.models.ArticleItem
import com.kroman.presentation.models.SourceItem

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    homeViewModel.getTopHeadlines()
    val articles by homeViewModel.newsFeed.observeAsState(listOf())
    ArticleList(articles = articles)
}

@Composable
fun ArticleList(articles: List<ArticleItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 4.dp)
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(articles) { article ->
            ArticleCard(article = article) {
            }
        }
    }
}

@Composable
fun ArticleCard(article: ArticleItem, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        Image(
            painter = rememberImagePainter(article.image),
            contentDescription = null,
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
                color = Color.Black,
                fontWeight = FontWeight.Normal,
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = article.description,
                textAlign = TextAlign.Start,
                fontSize = 12.sp,
                color = Color.Black,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
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