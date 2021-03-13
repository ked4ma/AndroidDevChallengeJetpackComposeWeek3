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
package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.view.Home
import com.example.androiddevchallenge.view.Login
import com.example.androiddevchallenge.view.Welcome

object Destinations {
    const val WELCOME = "welcome"
    const val LOGIN = "login"
    const val HOME = "home"
}

@Composable
fun NavGraph(
    startDestination: String = Destinations.WELCOME
) {
    val navController = rememberNavController()

    val actions = remember(navController) { Actions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Destinations.WELCOME) {
            Welcome(actions.goLogin)
        }
        composable(Destinations.LOGIN) {
            Login(actions.goHome)
        }
        composable(Destinations.HOME) {
            Home()
        }
    }
}

private class Actions(navController: NavHostController) {
    val goLogin: () -> Unit = {
        navController.navigate(Destinations.LOGIN)
    }

    val goHome: () -> Unit = {
        navController.navigate(Destinations.HOME) {
            popUpTo(0) { inclusive = false }
        }
    }
}
