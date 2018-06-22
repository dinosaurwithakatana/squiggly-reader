package io.dwak.squiggly.data.module

import dagger.Module
import io.dwak.squiggly.db.inject.module.DbModule
import io.dwak.squiggly.services.inject.ServiceModule

@Module(includes = [
  DbModule::class,
  ServiceModule::class
])
abstract class RepoModule
