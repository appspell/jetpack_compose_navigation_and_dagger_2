package com.appspell.composenavigationanddagger2.screen1.di

import com.appspell.composenavigationanddagger2.screen1.Screen1ViewModel
import dagger.Component

@Component(
    modules = [Screen1Module::class]
)
@Screen1Scope
interface Screen1Component {

    @Component.Builder
    interface Builder {
        fun build(): Screen1Component
    }

    fun getViewModel() : Screen1ViewModel
}