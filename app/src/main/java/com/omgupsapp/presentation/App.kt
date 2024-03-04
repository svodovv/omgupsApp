package com.omgupsapp.presentation

import androidx.annotation.DrawableRes
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import com.omgupsapp.R
import com.omgupsapp.data.DataStoreManager
import com.omgupsapp.presentation.activity.Scaffold.NavigationBarComposable
import com.omgupsapp.presentation.activity.Scaffold.TopAppBarComposable
import com.omgupsapp.presentation.navigation.NavHostComposable
import com.omgupsapp.presentation.theme.OmgupsAppTheme


data class BottomNavigationItem(
    val tittle: String, // Что будет написано в title
    val route: String, // Путь до страницы
    @DrawableRes val selectedIcon: Int,// Выбранный значёк
    @DrawableRes val unselectedIcon: Int,//Не выбранный значек
    val hasNews: Boolean, //Есть ли уведомление
    val badeCount: Int? = null // Колличество уведомлений на странице
)

@Composable
fun App(dataStoreManager: DataStoreManager, navController: NavHostController) {
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

        Scaffold(
            topBar = {
                     TopAppBarComposable(navController = navController)
            }, bottomBar = {
                NavigationBarComposable(
                    itemsBottomBar = itemsBottomBar,
                    selectedItemIndex = selectedItemIndex,
                    navController = navController
                )
            }) {paddingValues ->
            NavHostComposable(
                navController = navController,
                dataStoreManager = dataStoreManager,
                paddingValues
            )
        }

    }
}
