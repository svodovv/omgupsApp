package com.omgupsapp.presentation.ui.SettingsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.omgupsapp.presentation.ui.LoginScreen.components.ErrorScreen
import com.omgupsapp.presentation.ui.LoginScreen.components.LoadingScreen

@Composable
fun LogoutScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    logOutViewModel: LogoutViewModel = hiltViewModel(),
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val stateLogout = logOutViewModel.stateLogout

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        if (!stateLogout.value.isLogout) {
            Column(
                modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
                horizontalAlignment = CenterHorizontally
            ) {
                Text(text = "HOME SCREEN")
                Button(onClick = {
                    logOutViewModel.logout()
                    authViewModel.logOut()
                    navController.navigate(Screen.AuthScreen.route)
                }) {
                    Text(text = "Выход")
                }
            }
        } else if (stateLogout.value.isLoading) {
            LoadingScreen(modifier = Modifier.align(CenterHorizontally))
        } else {
            ErrorScreen(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(CenterHorizontally),
                textError = stateLogout.value.error,
                navController,
                Screen.LogOutScreen.route // Поменять!!
            )
        }
    }
}




