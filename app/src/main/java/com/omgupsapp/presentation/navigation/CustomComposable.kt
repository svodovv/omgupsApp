package com.omgupsapp.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.omgupsapp.presentation.BottomNavigationItem
import com.omgupsapp.presentation.activity.Scaffold.ScaffoldComposable


fun NavGraphBuilder.customComposable(
    route: String,
    navController: NavHostController,
    itemsBottomBar: List<BottomNavigationItem>,
    selectedItemIndex: MutableState<Int>,
    content: @Composable (PaddingValues) -> Unit
){
    composable(route){
        ScaffoldComposable(
            navController = navController,
            itemsBottomBar = itemsBottomBar,
            selectedItemIndex = selectedItemIndex
        ) {
            content(it)
        }
    }
}