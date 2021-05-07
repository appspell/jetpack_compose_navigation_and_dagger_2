package com.appspell.composenavigationanddagger2.screen2

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class Screen2ViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow<String>("Second screen")
    val state: StateFlow<String>
        get() = _state

    init {
        Log.i("COMPNAVILOG", "Screen2ViewModel.init")

        // Launch timer to see how our VM works in "background"
        // when we change screens
        viewModelScope.launch {
            var counter = 1L
            while (true) {
                counter++
                _state.value = "Second screen timer: $counter"
                delay(1000)
                Log.i("COMPNAVILOG", "Timer: $counter. VM: ${this@Screen2ViewModel}")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("COMPNAVILOG", "Screen2ViewModel.onCleared()")
    }
}