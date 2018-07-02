package io.dwak.squigglyreader.inject.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.dwak.squiggly.fetcher.inject.FetcherModule
import io.dwak.squiggly.repo.module.RepoModule
import io.dwak.squiggly.inject.ModifierModule
import io.dwak.squiggly.uploader.inject.UploaderModule
import io.dwak.squigglyreader.SquigglyReaderApplication
import io.dwak.squigglyreader.inject.module.ActivityModule
import io.dwak.squigglyreader.inject.module.AppModule
import io.dwak.squigglyreader.inject.module.CoroutineModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
  ActivityModule::class,
  AndroidSupportInjectionModule::class,
  AppModule::class,
  CoroutineModule::class,
  FetcherModule::class,
  ModifierModule::class,
  RepoModule::class,
  UploaderModule::class
])
interface AppComponent : AndroidInjector<SquigglyReaderApplication> {
  @Component.Builder
  abstract class Builder : AndroidInjector.Builder<SquigglyReaderApplication>()
}