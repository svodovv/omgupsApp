package com.omgupsapp.presentation.ui.homeScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.omgupsapp.presentation.theme.OmgupsAppTheme



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    /*val itemsBottomBar = listOf(
        BottomNavigationItem(
            tittle = "Главная",
            route = Screen.HomeScreen.route,
            selectedIcon = R.drawable.rounded_home_app_logo_30,
            unselectedIcon = R.drawable.rounded_home_app_logo_30,
            hasNews = false,
        ),
        BottomNavigationItem(
            tittle = "Профиль",
            route = Screen.UserProfileScreen.route,
            selectedIcon = R.drawable.sharp_person_30,
            unselectedIcon = R.drawable.sharp_person_30,
            hasNews = false,
        ),
        BottomNavigationItem(
            tittle = "Расписание",
            route = Screen.ScheduleScreen.route,
            selectedIcon = R.drawable.round_menu_30,
            unselectedIcon = R.drawable.round_menu_30,
            hasNews = false,
        ),
    )
    val selectedItemIndex = rememberSaveable {
        mutableStateOf(0)
    }
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = {
            Text(
                text = "Главная", style = MaterialTheme.typography.displayMedium
            )
        }, actions = {
            IconButton(onClick = { *//*TODO*//* }) {
                Icon(
                    painterResource(id = R.drawable.sharp_notifications_30),
                    contentDescription = "Notifications button"
                )
            }
            IconButton(onClick = { navController.navigate(Screen.LogOutScreen.route) }) {
                Icon(
                    painterResource(id = R.drawable.sharp_settings_30),
                    contentDescription = "Settings icon"
                )
            }
        })
    }, bottomBar = {
        NavigationBar {
            itemsBottomBar.forEachIndexed { index, it ->
                NavigationBarItem(selected = false, onClick = {
                    selectedItemIndex.value = index
                    navController.navigate(it.route)
                }, label = { Text(text = it.tittle) }, icon = {
                    BadgedBox(badge = {
                        //Какое либо уведомление (как пометка о непрочитанных сообщениях)
                    }) {
                        Icon(
                            painterResource(
                                id = if (index == selectedItemIndex.value) {
                                    it.selectedIcon
                                } else it.unselectedIcon
                            ), contentDescription = it.tittle
                        )
                    }
                })
            }
        }
    }

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomePage(navController = navController)
        }
    }*/

    Column(
        modifier = Modifier
            .fillMaxSize()

            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomePage(navController = navController)
    }
}

@Composable
fun HomePage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Home screen")
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    OmgupsAppTheme {
        HomeScreen(navController = rememberNavController())
    }
}