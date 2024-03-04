package com.omgupsapp.presentation.ui.userProfileScreen.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun UserProfileScreen(navController: NavController, paddingValues: PaddingValues) {
    Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
        Text(text = "User profile screen")
    }
}