package com.example.treasurehunt.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.treasurehunt.components.CustomButton
import com.example.treasurehunt.components.CustomText
import com.example.treasurehunt.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CustomText(text = "Bem-vindo à caça ao tesouro!")
        CustomButton(
            text = "Iniciar Caça ao Tesouro",
            onClick = { navController.navigate(Screen.Clue1.route) },
        )
    }
}