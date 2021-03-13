package com.example.androiddevchallenge.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Welcome() {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = MyTheme.images.welcomeBg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(top = 72.dp)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier
                        .height(280.dp)
                        .fillMaxWidth()
                        .padding(start = 88.dp),
                    alignment = Alignment.CenterStart,
                    painter = painterResource(id = MyTheme.images.welcomeIllos),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Image(
                modifier = Modifier
                    .padding(top = 48.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = MyTheme.images.logo),
                contentDescription = null,
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
                    .paddingFromBaseline(top = 32.dp, bottom = 40.dp),
                text = stringResource(R.string.welcome),
                color = MyTheme.colors.onPrimary,
                style = MyTheme.typography.subtitle1
            )
            Button(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MyTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MyTheme.colors.secondary,
                    contentColor = MyTheme.colors.onSecondary
                ),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = stringResource(R.string.create_account),
                    style = MyTheme.typography.button
                )
            }
            TextButton(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = MyTheme.domainColors.loginButtonText
                ),
                onClick = { /*TODO*/ }
            ) {
                Text(text = stringResource(R.string.login))
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun WelcomePreview() {
    MyTheme {
        Surface(modifier = Modifier.background(color = MyTheme.colors.background)) {
            Welcome()
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun WelcomeDarkPreview() {
    MyTheme(darkTheme = true) {
        Surface(modifier = Modifier.background(color = MyTheme.colors.background)) {
            Welcome()
        }
    }
}