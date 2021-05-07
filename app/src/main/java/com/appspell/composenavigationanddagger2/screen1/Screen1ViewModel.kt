package com.appspell.composenavigationanddagger2.screen1

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Screen1ViewModel : ViewModel() {
    private val _state = MutableStateFlow<String>("First screen")
    val state: StateFlow<String>
        get() = _state

    init {
        Log.i("COMPNAVILOG", "Screen1ViewModel.init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("COMPNAVILOG", "Screen1ViewModel.onCleared()")
    }
}