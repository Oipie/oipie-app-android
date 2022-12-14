package com.acidtango.auth_presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.acidtango.auth_presentation.ui.components.EmailPasswordSet
import com.acidtango.auth_presentation.viewModels.LoginVM
import com.acidtango.core_ui.theme.Purple

@Composable
fun LoginScreen(
    viewModel: LoginVM = hiltViewModel(),
    onLogin: () -> Unit,
    onRegistration: () -> Unit
) {

    Surface() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Oipie".uppercase(),
                style = TextStyle(fontSize = 48.sp, fontWeight = FontWeight.Bold, color = Purple)
            )
            Spacer(modifier = Modifier.height(72.dp))
            EmailPasswordSet(
                emailValue = viewModel.email,
                onChangeEmail = viewModel::onEmailChange,
                passwordValue = viewModel.password,
                onChangePassword = viewModel::onPasswordChange
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    viewModel.readToken()
                    onLogin()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Purple,
                    contentColor = Color.White
                ),
                elevation = null
            ) {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    viewModel.readToken()
                    onRegistration()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Purple,
                    contentColor = Color.White
                ),
                elevation = null
            ) {
                Text(text = "Registrarse")
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}
