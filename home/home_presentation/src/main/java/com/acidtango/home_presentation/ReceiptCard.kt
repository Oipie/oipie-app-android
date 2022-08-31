package com.acidtango.home_presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.acidtango.core_ui.R
import com.acidtango.core_ui.theme.OipieTheme
import com.acidtango.home_presentation.components.InfoReceipt
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.zIndex
import coil.size.Scale

@Composable
fun ReceiptCard(imageUrl: String, modifier: Modifier = Modifier) {

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .scale(Scale.FILL)
            .build()
    )

    val localDensity = LocalDensity.current
    var heightIs by remember {
        mutableStateOf(0.dp)
    }

    val circleBtnSize = 81.dp
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .zIndex(1f)
                .padding(top = heightIs, start = 12.dp),
        ) {
            FloatingActionButton(
                onClick = {
                    Log.d("FAB", "CLICKED")
                },
                modifier = Modifier
                    .size(circleBtnSize),
                backgroundColor = Color.White,
            ) {
                Icon(painterResource(id = R.drawable.ic_heart_empty), "", tint = Color.Unspecified)
            }
        }

        Card(
            elevation = 4.dp,
            shape = RoundedCornerShape(20.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .heightIn(min = 0.dp, max = 400.dp)
                        .onGloballyPositioned { coordinates ->
                            heightIs =
                                with(localDensity) { coordinates.size.height.toDp() - (circleBtnSize / 2) }
                        }

                )
                Spacer(Modifier.height(40.dp))
                Text(
                    "Slutty Pumpkin".uppercase(),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
                )
                Spacer(Modifier.height(10.dp))

                Row() {
                    InfoReceipt(icon = R.drawable.ic_heart, value = "- 245")
                    Spacer(
                        Modifier
                            .width(35.dp)
                            .height(1.dp)
                    )
                    InfoReceipt(icon = R.drawable.ic_timer, value = "- 15 min.")
                }

                Spacer(Modifier.height(40.dp))
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewReceiptCard() {
    OipieTheme() {
        ReceiptCard(imageUrl = "https://static.wikia.nocookie.net/himym/images/8/82/Barney%27s_costume.png")
    }
}