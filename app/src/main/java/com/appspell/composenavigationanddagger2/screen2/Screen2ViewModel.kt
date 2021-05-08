package com.appspell.composenavigationanddagger2.screen2

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class Screen2ViewModel(
    val repository: Screen2Repository
) : ViewModel() {
    private val _state = MutableStateFlow<String>("Second screen")
    val state: StateFlow<String>
        get() = _state

    init {
        Log.i("COMPNAVILOG", "Screen2ViewModel.init")

        // Launch timer to see how our VM works in "background"
        // when we change screens
        viewModelScope.launch {
            repository.startCounter()
                .collect { value ->
                    _state.value = value
                }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("COMPNAVILOG", "Screen2ViewModel.onCleared()")
    }
}