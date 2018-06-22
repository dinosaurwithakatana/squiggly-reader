package io.dwak.squiggly.data.transformer

import io.dwak.squiggly.data.model.UiComment
import io.dwak.squiggly.db.entity.DbComment
import io.dwak.squiggly.services.model.ApiComment

// region comments

fun ApiComment.toDbComment(): DbComment = TODO()
fun DbComment.toUiComment(): UiComment = TODO()
fun UiComment.toDbComment(): DbComment = TODO()
fun DbComment.toApiComment(): ApiComment = TODO()

// endregion
