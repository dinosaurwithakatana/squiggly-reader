package io.dwak.squiggly.uploader.inject

import dagger.Binds
import dagger.Module
import io.dwak.squiggly.uploader.TildesUploader
import io.dwak.squiggly.uploader.Uploader

@Module
abstract class UploaderModule {
  @Binds abstract fun uploader(tildesUploader: TildesUploader): Uploader
}