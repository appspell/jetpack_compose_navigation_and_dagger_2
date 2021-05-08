package com.appspell.composenavigationanddagger2

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
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

        Log.i("COMPNAVILOG", "Activity onCreate")

        setContent {
            val navController = rememberNavController()

            NavHost(navController, startDestination = NavigationDestination.Screen1.destination) {
                composable(NavigationDestination.Screen1.destination) {

                    Log.i("COMPNAVILOG", "Navigation Screen1")

                    // option #1 create a component inside NavBackStackEntry,
                    // which can be helpful if we need to provide more than one object from DI here
                    val component = DaggerScreen1Component.builder().build()

                    val viewModel: Screen1ViewModel = daggerViewModel {
                        Log.i("COMPNAVILOG", "create VM: Screen1ViewModel")

                        component.getViewModel()
                    }

                    Screen1(
                        navController = navController,
                        viewModel = viewModel
                    )
                }
                composable(NavigationDestination.Screen2.destination) {
                    Log.i("COMPNAVILOG", "Navigation Screen2")

                    val viewModel: Screen2ViewModel = daggerViewModel {
                        Log.i("COMPNAVILOG", "create VM: Screen2ViewModel")

                        // option #2 create DI component and instantly get ViewModel instance
                        DaggerScreen2Component.builder().build().getViewModel()
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