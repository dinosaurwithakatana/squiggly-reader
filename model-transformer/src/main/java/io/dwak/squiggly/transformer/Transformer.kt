package io.dwak.squiggly.transformer

import io.dwak.squiggly.common.interfaces.model.ApiModel
import io.dwak.squiggly.common.interfaces.model.DbModel
import io.dwak.squiggly.common.interfaces.model.UiModel

interface Transformer<A: ApiModel, D: DbModel, U: UiModel> {
  fun A.transformToDb(): D

  fun D.transformToApi(): A
  fun D.transformToUi(): U

  fun U.transformToDb(): D
}