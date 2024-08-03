package com.uzb7.woocommerce.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uzb7.woocommerce.screen.CreateAccountScreen
import com.uzb7.woocommerce.screen.ForgotPasswordScreen
import com.uzb7.woocommerce.screen.HomeScreen
import com.uzb7.woocommerce.screen.LoginScreen
import com.uzb7.woocommerce.screen.OTPVerificationScreen
import com.uzb7.woocommerce.screen.SplashScreen
import com.uzb7.woocommerce.screen.UpdatePasswordScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = NavigationItem.Splash.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Splash.route) {
            SplashScreen(navController)
        }
        composable(NavigationItem.Login.route) {
            LoginScreen(navController)
        }
        composable(NavigationItem.Home.route) {
            HomeScreen(navController)
        }
        composable(NavigationItem.ForgotPassword.route) {
            ForgotPasswordScreen(navController)
        }
        composable(NavigationItem.OTPVerification.route) {
            OTPVerificationScreen(navController)
        }
        composable(NavigationItem.CreateAccount.route) {
            CreateAccountScreen(navController)
        }
        composable(NavigationItem.UpdatePassword.route) {
            UpdatePasswordScreen(navController)
        }


    }
}