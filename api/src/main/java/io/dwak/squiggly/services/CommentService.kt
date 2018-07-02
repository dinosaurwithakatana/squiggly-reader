package io.dwak.squiggly.services

import io.dwak.squiggly.model.ApiComment
import kotlinx.coroutines.experimental.Deferred

interface CommentService {
  fun getComment(commentId: String): Deferred<ApiComment>
  fun postComment(comment: ApiComment): Deferred<Unit>
}