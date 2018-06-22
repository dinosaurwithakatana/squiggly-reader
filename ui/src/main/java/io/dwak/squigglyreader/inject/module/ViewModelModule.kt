package io.dwak.squigglyreader.inject.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.dwak.squigglyreader.MainViewModel
import io.dwak.squigglyreader.inject.DaggerViewModelFactory
import io.dwak.squigglyreader.inject.key.ViewModelKey

@Module
abstract class ViewModelModule {
  @Binds
  abstract fun viewModelFactory(daggerViewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory

  @Binds
  @IntoMap
  @ViewModelKey(MainViewModel::class)
  abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}