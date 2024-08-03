package com.uzb7.woocommerce.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import com.uzb7.woocommerce.R
import com.uzb7.woocommerce.ui.theme.LabelTextColor
import com.uzb7.woocommerce.utils.NavigationItem
import com.uzb7.woocommerce.views.CodeTextField
import com.uzb7.woocommerce.views.CustomButton


@Composable
fun OTPVerificationScreen(
    navController: NavHostController? = null,
) {

    var code by rememberSaveable {
        mutableStateOf("")
    }

    BackHandler {
        navController?.popBackStack()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(
                modifier = Modifier.padding(start = 10.dp),
                onClick = {
                    navController?.popBackStack()
                },
            ) {
                Image(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back",
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_group),
            contentDescription = "Lock",
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "OTP Verification",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                letterSpacing = 0.22.sp,
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier.padding(horizontal = 50.dp),
            text = "Please enter a 4 digit code that sent to your email address",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = LabelTextColor,
                textAlign = TextAlign.Center,
                letterSpacing = 0.16.sp,
            )
        )

        Spacer(modifier = Modifier.height(48.dp))

        CodeTextField(
            value = code,
            length = 4
        ) {
            code = it
        }

        Spacer(modifier = Modifier.height(48.dp))

        CustomButton(
            text = "VERIFY AND PROCEED",
            onClick = {
                navController?.navigate(NavigationItem.UpdatePassword.route)
            }
        )

        Spacer(modifier = Modifier.height(34.dp))

        TextButton(
            onClick = {
                //TODO()
                println("Resend code")
            }
        ) {

            Text(
                text = "RE-SEND",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color.Black,
                    letterSpacing = 0.16.sp,
                )
            )

        }

    }

}


@Preview
@Composable
private fun OTPVerificationScreenPreview() {
    OTPVerificationScreen()
}