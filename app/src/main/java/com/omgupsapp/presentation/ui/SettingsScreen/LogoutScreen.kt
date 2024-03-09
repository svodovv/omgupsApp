package com.omgupsapp.presentation.ui.SettingsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.omgupsapp.presentation.Screen
import com.omgupsapp.presentation.ui.LoginScreen.AuthViewModel

@Composable
fun LogoutScreen(
    navController: NavController,
    logOutViewModel: LogoutViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {

        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            Text(text = "HOME SCREEN")
            Button(onClick = {
                logOutViewModel.logout()
                navController.navigate(Screen.AuthScreen.route)
            }) {
                Text(text = "Выход")
            }
        }
    }
}




