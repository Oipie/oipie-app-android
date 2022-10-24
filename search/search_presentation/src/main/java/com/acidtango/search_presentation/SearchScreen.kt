package com.acidtango.search_presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.acidtango.core_ui.theme.OipieTheme

@Composable
fun SearchScreen() {

    val connectivityObserver = NetworkConnectivityObserver(LocalContext.current)

    val status by connectivityObserver.observe()
        .collectAsState(initial = ConnectivityObserver.Status.Unavailable)


    Surface(modifier = Modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center) {
            Column {
                Text(text = "Search screen", textAlign = TextAlign.Center)
                Text(text = "Network status: $status")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchScreen() {
    OipieTheme() {
        SearchScreen()
    }
}
