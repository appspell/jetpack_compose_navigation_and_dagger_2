package com.appspell.composenavigationanddagger2

sealed class NavigationDestination(val destination: String) {
    object Screen1 : NavigationDestination("screen1")
    object Screen2 : NavigationDestination("screen2")
}