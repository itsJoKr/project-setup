package com.example.jokr.propermock.ui

import com.example.jokr.propermock.dagger.InjectionViewModelProvider
import com.example.jokr.propermock.dagger.ViewModelInjection
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @ViewModelInjection
    fun provideMainActivityViewModel(
        view: MainActivity,
        provider: InjectionViewModelProvider<MainViewModel>
    ) = provider.get(view, MainViewModel::class)

}