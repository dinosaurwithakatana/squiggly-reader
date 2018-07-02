package io.dwak.squiggly.db.inject

import dagger.MapKey
import io.dwak.squiggly.common.ModelType

@MapKey
annotation class ModelKey(val value: ModelType)
