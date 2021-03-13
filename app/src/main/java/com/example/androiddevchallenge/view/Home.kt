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
package com.example.androiddevchallenge.view

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.GardenItemData
import com.example.androiddevchallenge.data.ThemeItemData
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.util.NetworkImage
import dev.chrisbanes.accompanist.insets.navigationBarsHeight
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun Home() {
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(Tabs.HOME) }
    val tabs = Tabs.values()
    Scaffold(
        backgroundColor = Color.Transparent,
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.navigationBarsHeight(additional = 56.dp),
                backgroundColor = MyTheme.colors.primary,
                elevation = MyTheme.elevations.bottomNavigation
            ) {
                tabs.forEach { tab ->
                    BottomNavigationItem(
                        icon = { Icon(tab.icon, contentDescription = null) },
                        label = { Text(stringResource(tab.title)) },
                        selected = tab == selectedTab,
                        onClick = {
                            // TODO activate
                            // setSelectedTab(tab)
                        },
                        selectedContentColor = MyTheme.colors.onPrimary,
                        modifier = Modifier.navigationBarsPadding()
                    )
                }
            }
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        when (selectedTab) {
            Tabs.HOME -> HomeView(modifier)
            else -> Unit
        }
    }
}

@Composable
fun HomeView(modifier: Modifier = Modifier) {
    var search by remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = ((40 - 8).dp))
                .padding(horizontal = 16.dp),
            value = search,
            label = {
                Text(
                    text = stringResource(R.string.search),
                    style = MyTheme.typography.body1,
                    color = MyTheme.colors.onPrimary,
                )
            },
            textStyle = MyTheme.typography.body1,
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MyTheme.colors.onPrimary
            ),
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            onValueChange = { search = it },
        )
        BrowseThemes()
        GardenItems()
    }
}

@Composable
private fun ColumnScope.BrowseThemes() {
    Text(
        modifier = Modifier
            .paddingFromBaseline(top = 32.dp)
            .padding(horizontal = 16.dp),
        text = stringResource(R.string.browse_themes),
        color = MyTheme.colors.onPrimary,
        style = MyTheme.typography.h1,
    )
    val items = remember { ThemeItemData.all }
    LazyRow(
        modifier = Modifier
            .height(168.dp)
            .padding(top = 16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)
    ) {
        items.forEachIndexed { index, item ->
            item {
                BrowseThemeItem(themeItem = item)
                if (index < items.lastIndex) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}

@Composable
private fun BrowseThemeItem(themeItem: ThemeItemData) {
    Card(
        modifier = Modifier.size(136.dp),
        backgroundColor = MyTheme.colors.background,
        shape = MyTheme.shapes.small,
        elevation = MyTheme.elevations.card
    ) {
        ConstraintLayout {
            val (image, text) = createRefs()
            NetworkImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                    },
                url = themeItem.thumbnail, contentDescription = null
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp)
                    .constrainAs(text) {
                        top.linkTo(image.bottom)
                        bottom.linkTo(parent.bottom)
                    },
                text = themeItem.name,
                maxLines = 1,
                style = MyTheme.typography.h2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun ColumnScope.GardenItems() {
    Row(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            modifier = Modifier
                .paddingFromBaseline(top = 32.dp)
                .weight(1F),
            text = stringResource(R.string.home_garden),
            color = MyTheme.colors.onPrimary,
            style = MyTheme.typography.h1,
        )
        Icon(
            modifier = Modifier
                .padding(top = 16.dp)
                .size(24.dp)
                .clickable { /* TODO */ },
            imageVector = Icons.Default.FilterList,
            contentDescription = null,
            tint = MyTheme.colors.onPrimary
        )
    }
    var items by remember { mutableStateOf(GardenItemData.all) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 8.dp)
    ) {
        items.forEachIndexed { index, item ->
            item {
                GardenItem(item) {
                    items = items.mapIndexed { i, v ->
                        if (index == i) v.copy(checked = !v.checked) else v
                    }
                }
                if (index < items.lastIndex) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
private fun GardenItem(item: GardenItemData, onChecked: () -> Unit = {}) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        val (image, name, desc, check, divider) = createRefs()
        NetworkImage(
            modifier = Modifier
                .size(64.dp)
                .clip(MyTheme.shapes.small)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            url = item.thumbnail, contentDescription = null
        )
        Text(
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp)
                .padding(start = 16.dp)
                .constrainAs(name) {
                    top.linkTo(parent.top)
                    start.linkTo(image.end)
                },
            text = item.name,
            maxLines = 1,
            color = MyTheme.colors.onPrimary,
            style = MyTheme.typography.h2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = Modifier
                .paddingFromBaseline(bottom = 24.dp)
                .padding(start = 16.dp)
                .constrainAs(desc) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(name.start)
                },
            text = stringResource(R.string.description),
            maxLines = 1,
            color = MyTheme.colors.onPrimary,
            style = MyTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        val check2 = createRef()
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .size(24.dp)
                .let {
                    if (item.checked) {
                        it.background(MyTheme.colors.secondary, MyTheme.shapes.small)
                    } else {
                        it.border(1.dp, MyTheme.colors.onPrimary, MyTheme.shapes.small)
                    }
                }
                .constrainAs(check) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .clickable { onChecked() },
        ) {
            if (item.checked) {
                Icon(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(16.dp),
                    imageVector = Icons.Default.Done,
                    contentDescription = null,
                    tint = MyTheme.colors.onSecondary
                )
            }
        }
        Divider(
            modifier = Modifier
                .constrainAs(divider) {
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
            color = MyTheme.colors.onPrimary.copy(alpha = 0.6F),
            startIndent = 72.dp
        )
    }
}

@Preview
@Composable
private fun HomePreview() {
    MyTheme {
        Surface(modifier = Modifier.background(color = MyTheme.colors.background)) {
            Home()
        }
    }
}

@Preview
@Composable
private fun BrowseThemesPreview() {
    MyTheme {
        Surface(modifier = Modifier.background(color = MyTheme.colors.background)) {
            Column {
                BrowseThemes()
            }
        }
    }
}

@Preview
@Composable
private fun BrowseThemeItemPreview() {
    val item = ThemeItemData(
        "Desert chic",
        "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg"
    )
    MyTheme {
        Surface(modifier = Modifier.background(color = MyTheme.colors.background)) {
            BrowseThemeItem(themeItem = item)
        }
    }
}

@Preview
@Composable
private fun GardenItemsPreview() {
    MyTheme {
        Surface(modifier = Modifier.background(color = MyTheme.colors.background)) {
            Column {
                GardenItems()
            }
        }
    }
}

@Preview
@Composable
private fun GardenItemPreview() {
    val item = GardenItemData(
        "Desert chic",
        "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg"
    )
    MyTheme {
        Surface(modifier = Modifier.background(color = MyTheme.colors.background)) {
            GardenItem(item)
        }
    }
}

private enum class Tabs(
    @StringRes val title: Int,
    val icon: ImageVector
) {
    HOME(R.string.home, Icons.Default.Home),
    FAVORITE(R.string.favorite, Icons.Default.FavoriteBorder),
    PROFILE(R.string.profile, Icons.Default.AccountCircle),
    CART(R.string.cart, Icons.Default.ShoppingCart)
}
