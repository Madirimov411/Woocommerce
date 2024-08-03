package com.uzb7.woocommerce.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.uzb7.woocommerce.R
import com.uzb7.woocommerce.ui.theme.ButtonBackground
import com.uzb7.woocommerce.ui.theme.HelperTextColor
import com.uzb7.woocommerce.ui.theme.LabelTextColor
import com.uzb7.woocommerce.utils.NavigationItem
import com.uzb7.woocommerce.views.CustomButton
import com.uzb7.woocommerce.views.CustomTextField
import com.uzb7.woocommerce.views.PasswordTextField

@Composable
fun CreateAccountScreen(navController: NavHostController? = null,) {

    var fullName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(42.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_create_account),
            contentDescription = "Lock",
        )

        Spacer(modifier = Modifier.height(22.dp))

        Text(
            text = "Create Account",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                letterSpacing = 0.22.sp,
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Create your new account",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = LabelTextColor,
                textAlign = TextAlign.Center,
                letterSpacing = 0.16.sp,
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        CustomTextField(
            text = fullName,
            labelText = "Full Name",
            onValueChange = {
                fullName = it
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomTextField(
            text = email,
            labelText = "Email Address",
            onValueChange = {
                email = it
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        PasswordTextField(
            passwordText = password,
            labelText = "Password",
            enableIcon = false,
            onValueChange = {
                password = it
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        CustomButton(
            text = "REGISTER NOW",
            icon = R.drawable.ic_next,
            onClick = {
                navController?.navigate(NavigationItem.Home.route)
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                text = "Already have an Account?",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    color = HelperTextColor,
                    letterSpacing = 0.15.sp,
                )
            )

            TextButton(
                onClick = {
                    navController?.navigate(NavigationItem.Login.route)
                }
            ) {
                Text(
                    text = "Log in",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = ButtonBackground,
                        letterSpacing = 0.15.sp,
                    )
                )
            }

        }

        Spacer(modifier = Modifier.height(24.dp))

    }


}

@Preview
@Composable
private fun CreateAccountScreenPreview() {
    CreateAccountScreen()
}