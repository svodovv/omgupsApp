package com.omgupsapp.presentation.activity.Scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import com.omgupsapp.presentation.BottomNavigationItem

@Composable
fun ScaffoldComposable(
    navController: NavHostController,
    itemsBottomBar: List<BottomNavigationItem>,
    selectedItemIndex: MutableState<Int>,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBarComposable(navController = navController)
        }, bottomBar = {
            NavigationBarComposable(
                itemsBottomBar = itemsBottomBar,
                selectedItemIndex = selectedItemIndex,
                navController = navController
            )
        }) { paddingValues ->
        content(paddingValues)
    }
}