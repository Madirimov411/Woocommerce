package com.uzb7.woocommerce.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uzb7.woocommerce.ui.theme.IconicColor
import com.uzb7.woocommerce.ui.theme.LabelTextColor
import com.uzb7.woocommerce.ui.theme.TextFieldBackground
import com.uzb7.woocommerce.ui.theme.TextFieldContentColor

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String,
    labelText: String,
    @DrawableRes icon: Int? = null,
    onValueChange: (String) -> Unit
) {

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(5.dp)),
        value = text,
        onValueChange = {
            onValueChange(it)
        },
        textStyle = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextFieldContentColor,
            letterSpacing = 0.15.sp,
        ),
        label = {
            Text(
                text = labelText,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = LabelTextColor,
                    letterSpacing = 0.16.sp,
                )
            )
        },
        singleLine = true,
        trailingIcon = {
            if (icon != null) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "Email",
                    tint = IconicColor
                )
            }
        },
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = LabelTextColor,
            focusedContainerColor = TextFieldBackground,
            unfocusedContainerColor = TextFieldBackground
        )
    )

}