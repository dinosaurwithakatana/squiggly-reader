package io.dwak.squiggly.transformer

import io.dwak.squiggly.db.entity.DbComment
import io.dwak.squiggly.model.ApiComment
import io.dwak.squiggly.model.UiComment

object CommentTransformer : Transformer<ApiComment, DbComment, UiComment>{
  override fun ApiComment.transformToDb(): DbComment = TODO()
  override fun DbComment.transformToApi(): ApiComment = TODO()
  override fun DbComment.transformToUi(): UiComment = TODO()
  override fun UiComment.transformToDb(): DbComment = TODO()
}