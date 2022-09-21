package com.acidtango.auth_presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.acidtango.auth_presentation.ui.components.TextFieldPurple
import com.acidtango.auth_presentation.viewModels.LoginVM
import com.acidtango.core_ui.R
import com.acidtango.core_ui.theme.Purple

@Composable
fun RegistrationScreen(
    viewModel: LoginVM = hiltViewModel(),
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

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
            TextFieldPurple(
                value = viewModel.email,
                onValueChange = viewModel::onEmailChange,
                label = "Nickname",
                placeHolder = "Nickname"
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextFieldPurple(
                value = viewModel.email,
                onValueChange = viewModel::onEmailChange,
                label = "Email",
                placeHolder = "Email"
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                value = viewModel.password,
                onValueChange = viewModel::onPasswordChange,
                label = {
                    Text(
                        text = "Password"
                    )
                },
                placeholder = {
                    Text(
                        text = "Password"
                    )
                },
                textStyle = TextStyle(),
                singleLine = true,
                maxLines = 1,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (passwordVisible)
                        R.drawable.ic_visibility_24
                    else R.drawable.ic_visibility_off_24

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = image),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Purple,
                    unfocusedBorderColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    viewModel.readToken()
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
                Text(text = "Signup")
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}
