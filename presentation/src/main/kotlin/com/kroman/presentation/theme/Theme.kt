package com.kroman.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Grey900,
    primaryVariant = Grey700,
    secondary = Grey500,
    background = Grey900
)

private val LightColorPalette = lightColors(
    primary = Grey50,
    primaryVariant = Grey700,
    secondary = Grey500,
    background = Color.White
)

@Composable
fun TopNewsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
  MaterialTheme(
      colors = if (darkTheme) DarkColorPalette else LightColorPalette,
      shapes = appShapes,
      content = content,
      typography = Typography
  )
}