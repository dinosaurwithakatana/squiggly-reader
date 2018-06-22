package io.dwak.squiggly.fetcher

import io.dwak.squiggly.common.ModelType

interface Fetcher {
  fun fetch(modelType: ModelType, id: String)
}