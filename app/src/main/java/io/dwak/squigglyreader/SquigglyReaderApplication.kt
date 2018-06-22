package io.dwak.squigglyreader

import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.dwak.squigglyreader.inject.component.DaggerAppComponent
import timber.log.Timber

class SquigglyReaderApplication : DaggerApplication(){
  override fun onCreate() {
    super.onCreate()

    AndroidThreeTen.init(this)
    Timber.plant(Timber.DebugTree())
  }

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
      DaggerAppComponent.builder().create(this)
}