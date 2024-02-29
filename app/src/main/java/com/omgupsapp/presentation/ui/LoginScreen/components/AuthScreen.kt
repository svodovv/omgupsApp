package com.omgupsapp.presentation.ui.LoginScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.omgupsapp.R
import com.omgupsapp.presentation.Screen
import com.omgupsapp.presentation.ui.LoginScreen.AuthViewModel


@Composable
fun AuthScreen(
    viewModel: AuthViewModel = hiltViewModel(), navController: NavController
) {
    val stateToken = viewModel.stateToken.value
    val stateAuthentication = viewModel.stateAuthentication.value

    var showError by remember { mutableStateOf(false) }

    if (stateToken.csrfToken) {
        if (stateAuthentication.isLoading && !showError) {
            Box( modifier = Modifier
                .fillMaxSize()) {
                LoadingScreen(modifier = Modifier.align(Center))
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .weight(2f)
                    .align(CenterHorizontally)
            ) {
                Image(
                    painterResource(id = R.drawable.logo_text),
                    contentDescription = stringResource(R.string.omgupslogo),
                    modifier = Modifier.align(Center)
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = CenterHorizontally
            ) {


                OutlinedTextField(
                    value = stateAuthentication.login,
                    onValueChange = {
                        viewModel.onChangeLogin(it)
                        viewModel.userStateAuth()
                        showError = false
                    },

                    label = {
                        Text(
                            text = stringResource(R.string.login),
                            color = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error else Color.Unspecified
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp, bottom = 0.dp, end = 8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.outline,
                        unfocusedBorderColor = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.outline,
                    )
                )

                // Password input
                OutlinedTextField(
                    value = stateAuthentication.password,
                    onValueChange = {
                        viewModel.onChangePassword(it)
                        viewModel.userStateAuth()
                        showError = false
                    },

                    label = {
                        Text(
                            text = stringResource(R.string.Password),
                            color = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error else Color.Unspecified
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.outline,
                        unfocusedBorderColor = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.outline,
                    )
                )

                Column(modifier = Modifier.padding(4.dp, top = 0.dp)) {
                    if (stateAuthentication.userAuthenticated == false) {
                        Text(
                            text = stringResource(R.string.ErrorInLoginOrPassword),
                            color = MaterialTheme.colorScheme.error,
                        )
                    } else if (showError) {
                        Text(
                            text = stringResource(R.string.LoginOrPasswordIsNull),
                            color = MaterialTheme.colorScheme.error,
                        )
                    } else Spacer(modifier = Modifier.padding(8.dp))
                }


                // Login button
                Button(
                    onClick = {
                        if (stateAuthentication.login.isNotBlank() && stateAuthentication.password.isNotBlank()) {
                            viewModel.userAuthenticated()
                        } else showError = true
                    }, modifier = Modifier
                        .padding(8.dp)
                        .width(200.dp),
                    enabled = !stateAuthentication.isLoading
                ) {
                    Text(stringResource(R.string.signIn))
                }
                LaunchedEffect(stateAuthentication) {
                    if (stateAuthentication.userAuthenticated == true) {
                        navController.navigate(Screen.HomeScreen.route){
                            popUpTo(Screen.AuthScreen.route){
                                inclusive = true
                            }
                        }
                    }
                    else if(stateAuthentication.userAuthenticated == false){
                        viewModel.isNotLoading()
                    }
                }
            }
        }
    } else if (stateToken.isLoading) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            LoadingScreen(modifier = Modifier.align(CenterHorizontally))
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            ErrorScreen(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(CenterHorizontally),
                textError = stateToken.error,
                navController,
                Screen.AuthScreen.route
            )
        }
    }
}



