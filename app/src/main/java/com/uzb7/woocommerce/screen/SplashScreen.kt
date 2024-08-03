package com.uzb7.woocommerce.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.uzb7.woocommerce.R
import com.uzb7.woocommerce.utils.NavigationItem
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController? = null,
) {

    LaunchedEffect(key1 = true) {
        delay(2000) // 2 sekund kutish
        navController?.navigate(NavigationItem.Login.route) {
            popUpTo(NavigationItem.Splash.route) { inclusive = true }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.img_splash),
            contentDescription = "Splash"
        )

    }


}