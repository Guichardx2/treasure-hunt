package com.example.treasurehunt.navigation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

//Screens
import com.example.treasurehunt.views.HomeScreen
import com.example.treasurehunt.views.ClueScreen1
import com.example.treasurehunt.views.ClueScreen2
import com.example.treasurehunt.views.ClueScreen3
import com.example.treasurehunt.views.TreasureScreen

@Preview(showBackground = true)
@Composable
fun Nav(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(
            Screen.Home.route,
            enterTransition = {
              fadeIn(animationSpec = tween(500, easing = FastOutSlowInEasing))
            },

            exitTransition = {
                fadeOut(animationSpec = tween(500, easing = FastOutSlowInEasing))
            }
        ) {
            HomeScreen(navController)
        }

        composable(
            Screen.Clue1.route,
            enterTransition = { slideInHorizontally(
                initialOffsetX = {1000},
                animationSpec = tween(600, easing = FastOutSlowInEasing))},

            exitTransition = { slideOutHorizontally(
                targetOffsetX = {-1000},
                animationSpec = tween(600, easing = FastOutSlowInEasing))}
            ) {
            ClueScreen1(navController)
        }

        composable(
            Screen.Clue2.route,
            enterTransition = { slideInHorizontally(
                initialOffsetX = {1000},
                animationSpec = tween(600, easing = FastOutSlowInEasing))
                },

            exitTransition = { slideOutHorizontally(
                targetOffsetX = {-1000},
                animationSpec = tween(600, easing = FastOutSlowInEasing))
                }) {
            ClueScreen2(navController)
        }

        composable(
            Screen.Clue3.route,
            enterTransition = { slideInHorizontally(
                initialOffsetX = {1000},
                animationSpec = tween(600, easing = FastOutSlowInEasing))},

            exitTransition = { slideOutHorizontally(
                targetOffsetX = {-1000},
                animationSpec = tween(600, easing = FastOutSlowInEasing))
                }) {
            ClueScreen3(navController)
        }

        composable(
            Screen.Treasure.route,
            enterTransition = {
                scaleIn(
                    initialScale = 0.8f,
                    animationSpec = tween(700, easing = FastOutSlowInEasing)
                )
            },
            exitTransition = {
                scaleOut(
                    targetScale = 1.2f,
                    animationSpec = tween(700, easing = FastOutSlowInEasing)
                )
            }
        ) {
            TreasureScreen(navController)
        }
    }
}
