package com.uzb7.woocommerce.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CodeTextField(
    modifier: Modifier = Modifier,
    value: String,
    length: Int,
    enabled: Boolean = true,
    onValueChange: (String) -> Unit,
) {
    val otp = remember {
        mutableStateOf(value)
    }
    BasicTextField(
        modifier = modifier,
        value = otp.value,
        singleLine = true,
        onValueChange = {
            if (it.length <= length) {
                otp.value = it
                onValueChange(it)
            }
        },
        enabled = enabled,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        keyboardActions = KeyboardActions(),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                repeat(length) { index ->

                    val currentChar = when {
                        index >= otp.value.length -> ""
                        else -> otp.value[index]
                    }

                    Box(
                        modifier = Modifier
                            .width(70.dp)
                            .height(72.dp)
                            .background(Color(0xFFF5F6F7), shape = RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = currentChar.toString(),
                            style = TextStyle(
                                color = Color(0xFF354764),
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Medium,
                                textAlign = TextAlign.Center,
                                letterSpacing = 0.3.sp,
                            )
                        )
                    }

                }
            }
        },
    )
}
