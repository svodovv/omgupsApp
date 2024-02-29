package com.omgupsapp.presentation.ui.LoginScreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.omgupsapp.presentation.theme.OmgupsAppTheme

@Composable
fun ErrorScreen(
    modifier: Modifier, textError: String, navController: NavController, route: String
) {
    Column(modifier = modifier) {
        Text(
            text = textError,
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.CenterHorizontally)
        )
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Button(
                onClick = {
                    navController.navigate(route)
                }) {
                Icon(Icons.Default.Refresh, contentDescription = "Refresh")
            }
        }
    }
}

@Preview
@Composable
fun ErrorScreenPreview() {
    OmgupsAppTheme {
        ErrorScreen(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            textError = "Ошибка соединения ввода вывода",
            navController = rememberNavController(),
            ""
        )
    }
}
