package io.dwak.squiggly.data.transformer

import io.dwak.squiggly.common.interfaces.model.Model

interface Transformer<T: Model, R: Model> {
  fun transform(input: T): R
}