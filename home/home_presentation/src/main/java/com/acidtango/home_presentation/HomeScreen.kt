package com.acidtango.home_presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.acidtango.core_ui.theme.OipieTheme

@Composable
fun HomeScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 90.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {

            ReceiptCard(
                imageUrl = "https://assets3.cbsnewsstatic.com/hub/i/r/2011/10/31/a9fc7282-a643-11e2-a3f0-029118418759/thumbnail/1200x630/9d595d8b5b0fd433d162fccc6ba7fe1a/101057_01405b.jpg",
                modifier = Modifier.padding(horizontal = 40.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    OipieTheme() {
        HomeScreen()
    }
}