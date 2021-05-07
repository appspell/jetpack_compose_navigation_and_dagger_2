package com.appspell.composenavigationanddagger2.screen1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Screen1ViewModel : ViewModel() {
    private val _state = MutableStateFlow<String>("First screen")
    val state: StateFlow<String>
        get() = _state
}