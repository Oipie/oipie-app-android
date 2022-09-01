package com.acidtango.home_presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
    LazyColumn(
        modifier = Modifier.padding(bottom = 89.dp),
        content = {
            items(viewModel.receipts.items) { receipt ->
                Spacer(modifier = Modifier.height(32.dp))
                ReceiptCard(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    receipt = receipt
                )

            }

            item { Spacer(modifier = Modifier.height(32.dp)) }
        })
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    OipieTheme() {
        HomeScreen()
    }
}