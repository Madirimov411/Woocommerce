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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.uzb7.woocommerce.R
import com.uzb7.woocommerce.ui.theme.LabelTextColor
import com.uzb7.woocommerce.utils.NavigationItem
import com.uzb7.woocommerce.views.CustomButton
import com.uzb7.woocommerce.views.CustomTextField


@Composable
fun ForgotPasswordScreen(
    navController: NavHostController? = null,
) {

    var email by remember {
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
            text = "Forgot Password?",
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
            modifier = Modifier.padding(horizontal = 54.dp),
            text = "Enter your email address associate with your Account",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = LabelTextColor,
                textAlign = TextAlign.Center,
                letterSpacing = 0.16.sp,
            )
        )

        Spacer(modifier = Modifier.height(38.dp))

        CustomTextField(
            text = email,
            labelText = "Email Address",
            icon = R.drawable.ic_sms,
            onValueChange = {
                email = it
            }
        )

        Spacer(modifier = Modifier.height(48.dp))

        CustomButton(
            text = "SEND NOW",
            onClick = {
                navController?.navigate(NavigationItem.OTPVerification.route)
            }
        )

    }

}

@Preview
@Composable
private fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen()
}