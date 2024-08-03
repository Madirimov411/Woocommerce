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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.uzb7.woocommerce.R
import com.uzb7.woocommerce.ui.theme.LabelTextColor
import com.uzb7.woocommerce.utils.NavigationItem
import com.uzb7.woocommerce.views.CustomButton
import com.uzb7.woocommerce.views.PasswordTextField


@Composable
fun UpdatePasswordScreen(
    navController: NavHostController? = null,
) {

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

    var confirmPasswordVisible by remember {
        mutableStateOf(false)
    }

    BackHandler {
        navController?.navigate(NavigationItem.Login.route) {
            popUpTo(NavigationItem.UpdatePassword.route) { inclusive = true }
        }
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
                    navController?.navigate(NavigationItem.Login.route)
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
            text = "Enter New Password",
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
            text = "Please enter your new password",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = LabelTextColor,
                textAlign = TextAlign.Center,
                letterSpacing = 0.16.sp,
            )
        )

        Spacer(modifier = Modifier.height(48.dp))

        PasswordTextField(
            passwordText = password,
            labelText = "Password",
            enableIcon = true,
            onValueChange = {
                password = it
            }
        )

        Spacer(modifier = Modifier.height(25.dp))

        PasswordTextField(
            passwordText = confirmPassword,
            labelText = "Confirm Password",
            enableIcon = true,
            onValueChange = {
                confirmPassword = it
            }
        )

        Spacer(modifier = Modifier.height(38.dp))

        CustomButton(
            text = "CONTINUE",
            onClick = {
                navController?.navigate(NavigationItem.Login.route)
            }
        )

    }

}

@Preview
@Composable
private fun UpdatePasswordScreenPreview() {
    UpdatePasswordScreen()
}