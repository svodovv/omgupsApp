package com.omgupsapp.presentation.ui.userProfileScreen.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.omgupsapp.presentation.Screen
import com.omgupsapp.presentation.ui.LoginScreen.AuthViewModel
import com.omgupsapp.presentation.ui.userProfileScreen.LogoutViewModel

@Composable
fun LogoutScreen(
    navController: NavController,
    logOutViewModel: LogoutViewModel = hiltViewModel(),
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val stateLogout = logOutViewModel.stateLogout

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        if (!stateLogout.value.isLogout) {
            Column(
                modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
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
        }
        else{
            ErrorScreen(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(CenterHorizontally),
                textError = stateLogout.value.error
            )
        }
    }
}

@Composable
fun ErrorScreen(
    modifier: Modifier, textError: String
) {
    Box(modifier = modifier) {
        Text(
            text = textError,
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun LoadingScreen(
    modifier: Modifier,
) {
    CircularProgressIndicator(modifier = modifier)
}


