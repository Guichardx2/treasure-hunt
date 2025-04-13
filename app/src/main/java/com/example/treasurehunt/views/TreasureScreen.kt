package com.example.treasurehunt.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.treasurehunt.components.CustomButton
import com.example.treasurehunt.components.CustomText
import com.example.treasurehunt.navigation.Screen
import com.example.treasurehunt.R

@Composable
fun TreasureScreen( navController: NavController ) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomText(text = "🎉 Parabéns! Você encontrou o tesouro! 🎉")
        CustomButton(
            text = "Voltar para o início",
            onClick = {
                navController.popBackStack(Screen.Home.route, inclusive = false)
                navController.navigate(Screen.Home.route)
            },
        )

        Image(
            painter = painterResource(id = R.drawable.bau),
            contentDescription = "Treasure",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}
