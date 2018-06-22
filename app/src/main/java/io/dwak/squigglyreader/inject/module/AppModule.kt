package io.dwak.squigglyreader.inject.module

import dagger.Module
import dagger.Provides
import io.dwak.squigglyreader.SquigglyReaderApplication

@Module
class AppModule {
  @Provides
  fun providesAppContext(application: SquigglyReaderApplication) =
      application.applicationContext
}