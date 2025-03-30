package com.example.treasurehunt.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Clue1 : Screen("clue1_screen")
    object Clue2 : Screen("clue2_screen")
    object Clue3 : Screen("clue3_screen")
    object Treasure : Screen("treasure_screen")
}