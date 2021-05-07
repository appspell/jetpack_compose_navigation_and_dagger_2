package com.appspell.composenavigationanddagger2.screen1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.appspell.composenavigationanddagger2.NavigationDestination
import com.appspell.composenavigationanddagger2.R

@Composable
fun Screen1(
    navController: NavController,
    viewModel: Screen1ViewModel
) {
    val viewState by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = viewState)

        Button(onClick = {
            navController.navigate(NavigationDestination.Screen2.destination)
        }) {
            Text(stringResource(R.string.tap_to_navigate))
        }
    }
}