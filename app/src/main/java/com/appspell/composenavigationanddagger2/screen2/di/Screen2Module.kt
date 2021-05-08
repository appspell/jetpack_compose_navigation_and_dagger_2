package com.appspell.composenavigationanddagger2.screen2.di

import com.appspell.composenavigationanddagger2.screen2.Screen2Repository
import com.appspell.composenavigationanddagger2.screen2.Screen2RepositoryImpl
import com.appspell.composenavigationanddagger2.screen2.Screen2ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class Screen2Module {

    @Module
    companion object {
        @Provides
        @Screen2Scope
        fun provideViewModel(repository: Screen2Repository): Screen2ViewModel =
            Screen2ViewModel(repository = repository)
    }

    @Binds
    @Screen2Scope
    abstract fun bindRepository(impl: Screen2RepositoryImpl): Screen2Repository
}