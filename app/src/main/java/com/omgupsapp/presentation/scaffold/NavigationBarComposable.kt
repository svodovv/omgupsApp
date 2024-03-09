package com.omgupsapp.presentation.scaffold

import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.omgupsapp.presentation.BottomNavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBarComposable(
    itemsBottomBar: List<BottomNavigationItem>,
    route: String,
    navController: NavHostController,
    selectedTitle: MutableState<String>
) {

    NavigationBar {
        itemsBottomBar.forEach {
            NavigationBarItem(
                selected = false,
                onClick = {
                    navController.navigate(it.route)
                },
                label = {
                    Text(
                        text = it.tittle,
                        color = if (it.route == route)
                            MaterialTheme.colorScheme.primary.also { _ ->
                                selectedTitle.value = it.tittle
                            }
                        else Color.Unspecified
                    )
                }, icon = {
                    BadgedBox(badge = {
                        //Какое либо уведомление (как пометка о непрочитанных сообщениях)
                    }) {

                        Icon(
                            painterResource(id = it.selectedIcon),
                            contentDescription = it.tittle,
                            tint = if (it.route == route)
                                MaterialTheme.colorScheme.primary
                            else Color.Unspecified
                        )
                    }
                }
            )

        }
    }
}

