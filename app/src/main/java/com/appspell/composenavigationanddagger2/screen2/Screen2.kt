package com.appspell.composenavigationanddagger2.screen2

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.appspell.composenavigationanddagger2.NavigationDestination
import com.appspell.composenavigationanddagger2.R

@Composable
fun Screen2(
    navController: NavController,
    viewModel: Screen2ViewModel
) {
    Log.i("COMPNAVILOG", "Screen2 recreated")

    val viewState by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = viewState, modifier = Modifier.padding(16.dp))

        Button(onClick = {
            navController.navigate(NavigationDestination.Screen1.destination) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        }) {
            Text(stringResource(R.string.tap_to_navigate))
        }
    }
}