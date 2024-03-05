package com.omgupsapp.presentation.activity.Scaffold

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.omgupsapp.R
import com.omgupsapp.presentation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComposable(navController: NavController){
    if (navController.currentDestination?.navigatorName != Screen.AuthScreen.route) {
        TopAppBar(title = {
            Text(
                text = "Главная", style = MaterialTheme.typography.displayMedium
            )
        }, actions = {
            IconButton(onClick = { /* НАВИГАЦИЯ ДО УВЕДОМЛЕНИЯ*/ }) {
                Icon(
                    painterResource(id = R.drawable.sharp_android_30),
                    contentDescription = "Notifications button"
                )
            }
            IconButton(onClick = { navController.navigate(Screen.LogOutScreen.route) }) {
                Icon(
                    painterResource(id = R.drawable.round_settings_30),
                    contentDescription = "Settings icon"
                )
            }
        })
    }
}