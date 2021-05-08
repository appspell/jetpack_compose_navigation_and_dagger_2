package com.appspell.composenavigationanddagger2.screen2

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface Screen2Repository {
    fun startCounter(): Flow<String>
}

class Screen2RepositoryImpl @Inject constructor() : Screen2Repository {
    private var counter = 1L

    override fun startCounter(): Flow<String> = flow {
        while (true) {
            counter++
            emit("Second screen timer: $counter")
            delay(1000)
            Log.i("COMPNAVILOG", "Timer: $counter. Repository: ${this@Screen2RepositoryImpl}")
        }
    }
}