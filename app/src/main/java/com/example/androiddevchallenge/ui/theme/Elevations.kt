package com.example.androiddevchallenge.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Elevations(
    val card: Dp = 1.dp,
    val snackbar: Dp = 2.dp,
    val bottomNavigation: Dp = 16.dp
)

internal val LocalElevations = staticCompositionLocalOf { Elevations() }