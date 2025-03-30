package com.example.treasurehunt.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.treasurehunt.components.CustomButton
import com.example.treasurehunt.components.CustomText
import com.example.treasurehunt.navigation.Screen

val cluesList= listOf(
    "O que é o que é? É clara e salgada",
    "Pesa mais que um elefante, mas não pesa nada",
    "Cabe em um olho."
)

@Composable
fun ClueScreen1(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomText("Pista 1")
        CustomText(cluesList[0], size = 1)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomButton(
                text = "Voltar",
                onClick = { navController.navigate(Screen.Home.route)},
            )
            CustomButton(
                text = "Próxima Pista",
                onClick = { navController.navigate(Screen.Clue2.route) },
            )
        }
    }
}

@Composable
fun ClueScreen2(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomText("Pista 2")
        CustomText(cluesList[1], size = 1)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomButton(
                text = "Voltar",
                onClick = { navController.navigate(Screen.Clue1.route) },
            )
            CustomButton(
                text = "Próxima Pista",
                onClick = { navController.navigate(Screen.Clue3.route) },
            )
        }
    }
}

@Composable
fun ClueScreen3(navController: NavController) {
    var guessTheRiddle= remember { mutableStateOf(false) }
    var userInput = remember { mutableStateOf("")}
    var errorMessage = remember { mutableStateOf("") }
    val result = "Lágrima"

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomText("Pista 3")
        CustomText(cluesList[2], size = 1)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomButton(
                text = "Voltar",
                onClick = { navController.navigate(Screen.Clue2.route) },
            )
            CustomButton(
                text = if (!guessTheRiddle.value) "O que é?" else "Verificar",
                onClick = {
                    if (!guessTheRiddle.value) {
                        guessTheRiddle.value = true
                    } else {
                        if (userInput.value.trim().equals(result, ignoreCase = true)) {
                            navController.navigate(Screen.Treasure.route)
                        } else {
                            errorMessage.value = "Resposta incorreta! Tente novamente."
                        }
                    }
                },
            )

        }
        if (guessTheRiddle.value) {
            TextField(
                value = userInput.value,
                onValueChange = {
                    userInput.value = it
                    errorMessage.value = ""
                },
                label = { Text("Digite sua resposta") },
                placeholder = { Text("Resposta") },
                modifier = Modifier
                    .padding(16.dp).fillMaxWidth()
            )

            if (errorMessage.value.isNotEmpty()) {
                Text(
                    text = errorMessage.value,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}
