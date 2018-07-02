package io.dwak.squigglyreader.inject.module

import android.content.Context
import androidx.preference.PreferenceDataStore
import dagger.Module
import dagger.Provides
import io.dwak.squiggly.prefs.DbPreferenceDataStore
import io.dwak.squigglyreader.SquigglyReaderApplication

@Module
class AppModule {
  @Provides
  fun providesAppContext(application: SquigglyReaderApplication) =
      application.applicationContext

  @Provides fun providesPrefDataStore(context: Context): PreferenceDataStore =
      DbPreferenceDataStore(context)
}