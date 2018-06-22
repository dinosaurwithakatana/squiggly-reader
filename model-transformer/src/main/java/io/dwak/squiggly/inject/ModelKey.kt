package io.dwak.squiggly.inject

import dagger.MapKey
import io.dwak.squiggly.common.ModelType

@MapKey
annotation class ModelKey(val value: ModelType)
