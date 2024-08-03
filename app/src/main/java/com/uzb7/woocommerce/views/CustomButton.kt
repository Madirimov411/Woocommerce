package com.uzb7.woocommerce.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uzb7.woocommerce.R
import com.uzb7.woocommerce.ui.theme.ButtonBackground

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes icon: Int? = null,
    onClick: () -> Unit
) {

    Button(
        modifier = modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonColors(
            containerColor = ButtonBackground,
            contentColor = Color.White,
            disabledContainerColor = ButtonBackground,
            disabledContentColor = Color.White
        ),
        onClick = onClick
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                modifier = Modifier.weight(1f),
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color.White,
                    letterSpacing = 0.16.sp,
                    textAlign = TextAlign.Center
                )
            )

            if (icon != null) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "Next"
                )
            }

        }

    }

}