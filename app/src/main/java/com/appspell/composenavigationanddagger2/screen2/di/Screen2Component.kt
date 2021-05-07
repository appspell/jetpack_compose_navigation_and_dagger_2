package com.appspell.composenavigationanddagger2.screen2.di

import com.appspell.composenavigationanddagger2.screen2.Screen2ViewModel
import dagger.Component

@Component(
    modules = [Screen2Module::class]
)
@Screen2Scope
interface Screen2Component {

    @Component.Builder
    interface Builder {
        fun build(): Screen2Component
    }

    fun getViewModel() : Screen2ViewModel
}