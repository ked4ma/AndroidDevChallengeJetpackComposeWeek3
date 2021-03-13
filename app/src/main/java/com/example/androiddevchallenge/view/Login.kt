package com.example.androiddevchallenge.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Login() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            modifier = Modifier
                .paddingFromBaseline(top = 184.dp)
                .align(Alignment.CenterHorizontally),
            text = "Log in with email",
            color = MyTheme.colors.onPrimary,
            style = MyTheme.typography.h1
        )
        CompositionLocalProvider(
            LocalTextStyle provides MyTheme.typography.body1,
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .height((56 + 8).dp)
                    .fillMaxWidth(),
                value = "",
                label = {
                    Text(
                        text = stringResource(R.string.email_address),
                        style = MyTheme.typography.body1,
                        color = MyTheme.colors.onPrimary,
                    )
                },
                singleLine = true,
                maxLines = 1,
                colors = TextFieldDefaults.outlinedTextFieldColors(),
                onValueChange = { /*TODO*/ },
            )
            OutlinedTextField(
                modifier = Modifier
                    .height((56 + 8).dp)
                    .fillMaxWidth(),
                value = "",
                label = {
                    Text(
                        text = stringResource(R.string.password),
                        style = MyTheme.typography.body1,
                        color = MyTheme.colors.onPrimary,
                    )
                },
                singleLine = true,
                maxLines = 1,
                colors = TextFieldDefaults.outlinedTextFieldColors(),
                onValueChange = { /*TODO*/ },
            )
        }
        val context = LocalContext.current
        val notice = remember {
            buildAnnotatedString {
                append(context.getString(R.string.notice))
                addStyle(
                    style = SpanStyle(textDecoration = TextDecoration.Underline),
                    start = 36,
                    end = 48
                )
                addStringAnnotation(
                    "URL",
                    annotation = "https://android-developers-jp.googleblog.com/2021/03/android-dev-challenge-3.html",
                    start = 36,
                    end = 48
                )
                addStyle(
                    style = SpanStyle(textDecoration = TextDecoration.Underline),
                    start = 68,
                    end = 82
                )
                addStringAnnotation(
                    "URL",
                    annotation = "https://android-developers-jp.googleblog.com/2021/03/android-dev-challenge-3.html",
                    start = 50,
                    end = 56
                )
            }
        }
        Text(
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp),
            text = notice,
            textAlign = TextAlign.Center,
            style = MyTheme.typography.body2,
            color = MyTheme.colors.onPrimary
        )
        Button(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(),
            shape = MyTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MyTheme.colors.secondary,
                contentColor = MyTheme.colors.onSecondary
            ),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = stringResource(R.string.login),
                style = MyTheme.typography.button
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun LoginPreview() {
    MyTheme {
        Surface(modifier = Modifier.background(color = MyTheme.colors.background)) {
            Login()
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun LoginDarkPreview() {
    MyTheme(darkTheme = true) {
        Surface(modifier = Modifier.background(color = MyTheme.colors.background)) {
            Login()
        }
    }
}