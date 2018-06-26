package io.dwak.squigglyreader.inject.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.dwak.squigglyreader.MainActivity

@Module
abstract class ActivityModule {

  @ContributesAndroidInjector(modules = [
    ViewModelModule::class
  ])
  abstract fun contributesMainActivityInjector(): MainActivity

}