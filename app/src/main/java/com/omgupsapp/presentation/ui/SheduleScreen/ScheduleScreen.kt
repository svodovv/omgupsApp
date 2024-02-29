package com.omgupsapp.presentation.ui.SheduleScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun ScheduleScreen (navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Schedule screen")
    }
}