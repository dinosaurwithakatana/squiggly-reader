package io.dwak.squiggly.fetcher.inject

import dagger.Binds
import dagger.Module
import io.dwak.squiggly.fetcher.Fetcher
import io.dwak.squiggly.fetcher.TildesFetcher

@Module
abstract class FetcherModule {
  @Binds abstract fun fetcher(fetcher: TildesFetcher): Fetcher
}