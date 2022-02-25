package com.kroman.presentation.ui.bookmarks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun BookmarksScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
    {
        Text(
            text = "BookmarksScreen",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun BookmarksScreenPreview() {
    BookmarksScreen()
}