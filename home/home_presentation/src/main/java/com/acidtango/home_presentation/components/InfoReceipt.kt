package com.acidtango.home_presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acidtango.core_ui.R
import com.acidtango.core_ui.theme.OipieTheme
import com.acidtango.home_presentation.ReceiptCard

@Composable
fun InfoReceipt(icon: Int, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painterResource(id = icon),
            tint = Color.Unspecified,
            contentDescription = null
        )
        Text(
            text = value,
            style = TextStyle(fontSize = 13.sp, color = Color(0xFF5E5E5E)),
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInfoReceipt() {
    OipieTheme() {
        InfoReceipt(icon = R.drawable.ic_heart, value = "- 245")
    }
}