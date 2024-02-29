package com.omgupsapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.omgupsapp.R
import com.omgupsapp.data.DataStoreManager
import com.omgupsapp.presentation.navigation.NavControllerComposable
import com.omgupsapp.presentation.theme.OmgupsAppTheme
import com.omgupsapp.presentation.ui.homeScreen.components.BottomNavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(dataStoreManager: DataStoreManager?, navController: NavHostController) {
    OmgupsAppTheme {
        val itemsBottomBar = listOf(
            BottomNavigationItem(
                tittle = "Главная",
                route = Screen.HomeScreen.route,
                selectedIcon = R.drawable.outline_home_app_logo_30,
                unselectedIcon = R.drawable.outline_home_app_logo_30,
                hasNews = false,
            ),
            BottomNavigationItem(
                tittle = "Профиль",
                route = Screen.UserProfileScreen.route,
                selectedIcon = R.drawable.round_person_30,
                unselectedIcon = R.drawable.round_person_30,
                hasNews = false,
            ),
            BottomNavigationItem(
                tittle = "Расписание",
                route = Screen.ScheduleScreen.route,
                selectedIcon = R.drawable.outline_menu_30,
                unselectedIcon = R.drawable.outline_menu_30,
                hasNews = false,
            ),
        )
        val selectedItemIndex = rememberSaveable {
            mutableStateOf<Int>(0)
        }
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
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

        }) {
            NavControllerComposable(
                navController = navController, dataStoreManager = dataStoreManager!!
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {}
        }

    }
}
