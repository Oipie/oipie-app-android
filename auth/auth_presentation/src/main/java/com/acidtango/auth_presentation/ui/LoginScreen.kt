package com.acidtango.auth_presentation.ui

import androidx.biometric.BiometricPrompt
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
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

    val context = LocalContext.current as FragmentActivity
    val executor = ContextCompat.getMainExecutor(LocalContext.current)
    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Biometric Authentication")
        .setSubtitle("Unlock using your biometric credential")
        .setNegativeButtonText("Cancel")
        .build()

    val biometricPromt =
        BiometricPrompt(
            context,
            executor,
            object : BiometricPrompt.AuthenticationCallback() {

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    viewModel.readToken()
                    onLogin()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                }
            }
        )



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
                    biometricPromt.authenticate(promptInfo)
                    /*viewModel.readToken()
                    onLogin()*/
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
