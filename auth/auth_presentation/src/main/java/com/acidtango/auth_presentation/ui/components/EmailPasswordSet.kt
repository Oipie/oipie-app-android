package com.acidtango.auth_presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.acidtango.core_ui.R

@Composable
fun EmailPasswordSet(
    emailValue: String,
    onChangeEmail: (String) -> Unit,
    passwordValue: String,
    onChangePassword: (String) -> Unit
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        TextFieldPurple(
            value = emailValue,
            onValueChange = onChangeEmail,
            label = "Email",
            placeHolder = "Email",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextFieldPurple(
            value = passwordValue,
            onValueChange = onChangePassword,
            label = "Password",
            placeHolder = "Password",
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible)
                    R.drawable.ic_visibility_24
                else R.drawable.ic_visibility_off_24

                IconButton(
                    modifier = Modifier.testTag("show_password_btn"),
                    onClick = { passwordVisible = !passwordVisible }
                ) {
                    Icon(
                        painter = painterResource(id = image),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                }
            }
        )
    }
}
