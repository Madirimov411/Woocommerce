package com.uzb7.woocommerce.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uzb7.woocommerce.R
import com.uzb7.woocommerce.ui.theme.IconicColor
import com.uzb7.woocommerce.ui.theme.LabelTextColor
import com.uzb7.woocommerce.ui.theme.TextFieldBackground
import com.uzb7.woocommerce.ui.theme.TextFieldContentColor

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    passwordText: String,
    labelText: String,
    enableIcon:Boolean,
    onValueChange: (String) -> Unit
) {

    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(5.dp)),
        value = passwordText,
        onValueChange = {
            onValueChange(it)
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
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

            if (enableIcon) {
                val image = if (passwordVisible)
                    R.drawable.ic_eye
                else R.drawable.ic_eye_slash

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = painterResource(id = image),
                        contentDescription = description,
                        tint = IconicColor
                    )
                }
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
