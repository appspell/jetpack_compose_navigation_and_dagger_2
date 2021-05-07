package com.appspell.composenavigationanddagger2.screen2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class Screen2ViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow<String>("Second screen")
    val state: StateFlow<String>
        get() = _state
}