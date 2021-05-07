package com.appspell.composenavigationanddagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appspell.composenavigationanddagger2.screen1.Screen1
import com.appspell.composenavigationanddagger2.screen1.Screen1ViewModel
import com.appspell.composenavigationanddagger2.screen1.di.DaggerScreen1Component
import com.appspell.composenavigationanddagger2.screen2.Screen2
import com.appspell.composenavigationanddagger2.screen2.Screen2ViewModel
import com.appspell.composenavigationanddagger2.screen2.di.DaggerScreen2Component
import com.appspell.composenavigationanddagger2.utils.daggerViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(navController, startDestination = NavigationDestination.Screen1.destination) {
                composable(NavigationDestination.Screen1.destination) {
                    val viewModel: Screen1ViewModel = daggerViewModel {
                        DaggerScreen1Component.builder().build()
                            .getViewModel()
                    }

                    Screen1(
                        navController = navController,
                        viewModel = viewModel
                    )
                }
                composable(NavigationDestination.Screen2.destination) {
                    val viewModel: Screen2ViewModel = daggerViewModel {
                        DaggerScreen2Component.builder().build()
                            .getViewModel()
                    }

                    Screen2(
                        navController = navController,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}