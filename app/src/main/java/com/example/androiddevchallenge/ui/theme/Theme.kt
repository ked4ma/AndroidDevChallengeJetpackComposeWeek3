/*
 * Copyright 2021 The Android Open Source Project
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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.R

private val DarkColorPalette = darkColors(
    primary = green900,
    secondary = green300,
    background = gray,
    surface = white150,
    onPrimary = Color.White,
    onSecondary = gray,
    onBackground = Color.White,
    onSurface = white850
)

private val LightColorPalette = lightColors(
    primary = pink100,
    secondary = pink900,
    background = Color.White,
    surface = white850,
    onPrimary = gray,
    onSecondary = Color.White,
    onBackground = gray,
    onSurface = gray
)

private val LightImages = Images(
    logo = R.drawable.ic_light_logo,
    welcomeIllos = R.drawable.ic_light_welcome_illos,
    welcomeBg = R.drawable.ic_light_welcome_bg
)
private val DarkImages = Images(
    logo = R.drawable.ic_dark_logo,
    welcomeIllos = R.drawable.ic_dark_welcome_illos,
    welcomeBg = R.drawable.ic_dark_welcome_bg
)

private val LightDomainColors = DomainColors(
    loginButtonText = pink900
)

private val DarkDomainColors = DomainColors(
    loginButtonText = Color.White
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val images = if (darkTheme) DarkImages else LightImages
    val domainColors = if (darkTheme) DarkDomainColors else LightDomainColors
    CompositionLocalProvider(
        LocalImages provides images,
        LocalColors provides domainColors
    ) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

object MyTheme {
    val colors: Colors
        @Composable
        get() = MaterialTheme.colors

    val typography: Typography
        @Composable
        get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable
        get() = MaterialTheme.shapes

    val elevations: Elevations
        @Composable
        get() = LocalElevations.current

    val images: Images
        @Composable
        get() = LocalImages.current

    val domainColors: DomainColors
        @Composable
        get() = LocalColors.current
}