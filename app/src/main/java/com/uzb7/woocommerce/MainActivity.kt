package com.uzb7.woocommerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.uzb7.woocommerce.screen.CreateAccountScreen
import com.uzb7.woocommerce.screen.ForgotPasswordScreen
import com.uzb7.woocommerce.screen.LoginScreen
import com.uzb7.woocommerce.screen.OTPVerificationScreen
import com.uzb7.woocommerce.ui.theme.WoocommerceTheme
import com.uzb7.woocommerce.utils.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            WoocommerceTheme {
                AppNavHost(navController = navController)
            }
        }
    }
}