package com.acidtango.receipts_presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.acidtango.core_ui.theme.OipieTheme

@Composable
fun ReceiptsScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Receipts screen", textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewReceiptsScreen() {
    OipieTheme() {
        ReceiptsScreen()
    }
}
