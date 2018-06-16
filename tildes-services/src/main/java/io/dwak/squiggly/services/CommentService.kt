package io.dwak.squiggly.services

import io.dwak.squiggly.services.model.ApiComment
import io.reactivex.Flowable

interface CommentService {
  fun getComment(commentId: String): Flowable<ApiComment>
}