package com.example.treasurehunt.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CustomText(text: String, size: Int = 4) {
    Text(
        text = text,
        style = when {
            size == 1 -> MaterialTheme.typography.bodyLarge
            size == 2 -> MaterialTheme.typography.bodyMedium
            size == 3 -> MaterialTheme.typography.bodySmall
            else -> MaterialTheme.typography.headlineMedium
        },
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Center
    )
}