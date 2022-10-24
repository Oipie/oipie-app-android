package com.acidtango.home_presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.acidtango.core_ui.theme.OipieTheme
import com.acidtango.core_ui.theme.Purple200

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    Surface(color = Color(0xFFFFD452)) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            if (viewModel.errorMessage.asString(context).isNotBlank()) {
                Text(viewModel.errorMessage.asString(context))
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                viewModel.receipts.items.forEach { receipt ->
                    ReceiptCard(
                        modifier = Modifier.padding(horizontal = 24.dp),
                        receipt = receipt
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
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
