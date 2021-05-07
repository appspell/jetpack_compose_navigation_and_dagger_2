package com.appspell.composenavigationanddagger2.screen1.di

import com.appspell.composenavigationanddagger2.screen1.Screen1ViewModel
import dagger.Module
import dagger.Provides

@Module
class Screen1Module {

    @Provides
    @Screen1Scope
    fun provideViewModel(): Screen1ViewModel = Screen1ViewModel()
}