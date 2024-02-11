package com.omgupsapp.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.omgupsapp.data.DataStoreManager
import com.omgupsapp.presentation.navigation.NavControllerComposable
import com.omgupsapp.presentation.theme.OmgupsAppTheme
import javax.inject.Inject

@Composable
fun App (dataStoreManager: DataStoreManager){
    OmgupsAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {

            val navController = rememberNavController()
            NavControllerComposable(
                navController = navController,
                dataStoreManager = dataStoreManager
            )
        }

    }
}

