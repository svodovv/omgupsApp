package com.omgupsapp.presentation.ui.LoginScreen.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoadingScreen(
    modifier: Modifier,
) {
    CircularProgressIndicator(modifier = modifier)
}