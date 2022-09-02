package com.acidtango.home_presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.acidtango.core_ui.theme.OipieTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    Surface(modifier = Modifier.padding(bottom = 89.dp)) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            viewModel.receipts.items.forEach { receipt ->
                ReceiptCard(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    receipt = receipt
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
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