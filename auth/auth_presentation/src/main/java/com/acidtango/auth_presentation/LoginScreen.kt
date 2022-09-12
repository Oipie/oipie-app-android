package com.acidtango.auth_presentation

import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun LoginScreen(onLogin: () -> Unit) {
    Surface {
        Text(text = "Login")
        Button(onClick = onLogin) {
            Text(text = "CLICK ME")
        }
    }
}