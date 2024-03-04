package com.omgupsapp.presentation.activity.Scaffold

import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.omgupsapp.presentation.BottomNavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBarComposable(
    itemsBottomBar: List<BottomNavigationItem>,
    selectedItemIndex: MutableState<Int>,
    navController: NavHostController
) {
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