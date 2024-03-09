package com.omgupsapp.presentation.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

import com.omgupsapp.presentation.BottomNavigationItem

@Composable
fun ScaffoldComposable(
    navController: NavHostController,
    itemsBottomBar: List<BottomNavigationItem>,
    content: @Composable (PaddingValues) -> Unit
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedTitle = remember { mutableStateOf("") }

    Scaffold(topBar = {
        GetTopBar(
            navController = navController,
            route = navBackStackEntry?.destination?.route.toString(),
            selectedTitle = selectedTitle.value
        )
    }, bottomBar = {
        GetNavigationBar(
            route = navBackStackEntry?.destination?.route.toString(),
            itemsBottomBar = itemsBottomBar,
            navController = navController,
            selectedTitle = selectedTitle
        )
    }) { paddingValues ->
        content(paddingValues)
    }
}