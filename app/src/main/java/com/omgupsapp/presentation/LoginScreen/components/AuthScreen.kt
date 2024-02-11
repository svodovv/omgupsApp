package com.omgupsapp.presentation.LoginScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.omgupsapp.R
import com.omgupsapp.presentation.LoginScreen.AuthState
import com.omgupsapp.presentation.LoginScreen.AuthViewModel


@Composable
fun AuthScreen(
    viewModel: AuthViewModel = hiltViewModel()
) {
    val stateToken = viewModel.stateToken.value
    val stateAuthentication = viewModel.stateAuthentication.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {

        if (stateToken.csrfToken) {
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
                    onValueChange = { viewModel.onChangeLogin(it) },
                    label = { Text(text = stringResource(R.string.login)) },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp, bottom = 0.dp, end = 8.dp)
                )

                // Password input
                OutlinedTextField(
                    value = stateAuthentication.password,
                    onValueChange = { viewModel.onChangePassword(it) },
                    label = { Text(text = stringResource(R.string.Password)) },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                // Login button
                Button(
                    onClick = {
                        viewModel.userAuthenticated()
                    }, modifier = Modifier
                        .padding(8.dp)
                        .width(200.dp)
                ) {
                    Text(stringResource(R.string.signIn))
                }
            }
        } else if (stateToken.isLoading) {
            LoadingScreen(modifier = Modifier.align(CenterHorizontally))
        } else {
            ErrorScreen(
                modifier = Modifier.fillMaxWidth().padding(20.dp).align(CenterHorizontally),
                state = stateToken
            )
        }
    }
}


@Composable
fun ErrorScreen(
    modifier: Modifier, state: AuthState
) {
    Box(modifier = modifier) {
        Text(
            text = state.error,
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Center)
        )
    }
}

@Composable
fun LoadingScreen(
    modifier: Modifier,
) {
    CircularProgressIndicator(modifier = modifier)
}



