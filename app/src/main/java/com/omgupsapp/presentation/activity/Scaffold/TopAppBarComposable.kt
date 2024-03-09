package com.omgupsapp.presentation.activity.Scaffold

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.omgupsapp.R
import com.omgupsapp.presentation.BottomNavigationItem
import com.omgupsapp.presentation.Screen
import com.omgupsapp.presentation.theme.OmgupsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComposable(
    navController: NavController,
    selectedTitle: String
    ) {
    TopAppBar(
        title = {
            Text(
                text = selectedTitle,
                style = MaterialTheme.typography.displayMedium
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* НАВИГАЦИЯ ДО УВЕДОМЛЕНИЯ*/ }) {
                Icon(
                    painterResource(id = R.drawable.sharp_android_30),
                    contentDescription = "Notifications button"
                )
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate(Screen.LogOutScreen.route) }) {
                Icon(
                    painterResource(id = R.drawable.round_settings_30),
                    contentDescription = "Settings icon"
                )
            }
        }
    )
}

@Preview
@Composable
fun TopAppBarPreview(){
    OmgupsAppTheme {
        TopAppBarComposable(
            navController = rememberNavController(),
            "Главная")
    }
}