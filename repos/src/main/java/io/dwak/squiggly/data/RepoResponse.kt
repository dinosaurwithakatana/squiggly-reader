package io.dwak.squiggly.data

import io.dwak.squiggly.common.interfaces.model.UiModel

sealed class RepoResponse<T: UiModel> {
  data class Success<T: UiModel>(val model: T): RepoResponse<T>()
  class NotFound<T: UiModel>: RepoResponse<T>()
}