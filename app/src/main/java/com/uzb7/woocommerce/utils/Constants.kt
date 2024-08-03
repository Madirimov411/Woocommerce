package com.uzb7.woocommerce.utils

enum class Screen {
    HOME,
    LOGIN,
    SPLASH,
    CREATE_ACCOUNT,
    FORGOT_PASSWORD,
    OTP_VERIFICATION,
    UPDATE_PASSWORD
}
sealed class NavigationItem(val route: String) {
    object Home : NavigationItem(Screen.HOME.name)
    object Login : NavigationItem(Screen.LOGIN.name)
    object Splash : NavigationItem(Screen.SPLASH.name)
    object CreateAccount : NavigationItem(Screen.CREATE_ACCOUNT.name)
    object ForgotPassword : NavigationItem(Screen.FORGOT_PASSWORD.name)
    object OTPVerification : NavigationItem(Screen.OTP_VERIFICATION.name)
    object UpdatePassword : NavigationItem(Screen.UPDATE_PASSWORD.name)
}