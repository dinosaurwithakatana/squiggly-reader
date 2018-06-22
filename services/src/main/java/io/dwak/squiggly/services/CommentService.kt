package io.dwak.squiggly.services

import io.dwak.squiggly.services.model.ApiComment
import io.reactivex.Flowable
import kotlinx.coroutines.experimental.Deferred

interface CommentService {
  fun getComment(commentId: String): Deferred<ApiComment>
}