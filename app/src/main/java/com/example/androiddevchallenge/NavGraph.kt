package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.*
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
    startDestination: String = Destinations.WELCOME,
//    animalsViewModel: AnimalsViewModel = viewModel()
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