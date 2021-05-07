package com.appspell.composenavigationanddagger2.screen2.di

import com.appspell.composenavigationanddagger2.screen1.Screen1ViewModel
import com.appspell.composenavigationanddagger2.screen1.di.Screen1Scope
import com.appspell.composenavigationanddagger2.screen2.Screen2ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
 class Screen2Module {

//    @Binds
//    @Screen2Scope
//    abstract fun provideViewModel(impl: Screen2ViewModel): Screen2ViewModel

    @Provides
    @Screen2Scope
    fun provideViewModel(): Screen2ViewModel = Screen2ViewModel()
}