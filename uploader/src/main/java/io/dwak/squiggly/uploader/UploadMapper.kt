package io.dwak.squiggly.uploader

import io.dwak.squiggly.common.interfaces.model.ApiModel
import io.dwak.squiggly.common.interfaces.model.DbModel
import kotlinx.coroutines.experimental.Deferred

interface UploadMapper {
  val modelMapper : (DbModel) -> ApiModel
  val networkCall: (ApiModel) -> Deferred<Unit>
}