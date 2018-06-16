package io.dwak.squiggly.data.repo

import io.dwak.squiggly.data.model.UiComment
import io.dwak.squiggly.db.dao.CommentDao
import io.dwak.squiggly.services.CommentService
import javax.inject.Inject

class CommentRepo @Inject constructor(
    private val commentDao: CommentDao,
    private val commentService: CommentService
) : Repo {

  fun getComment(commentId: String) : UiComment {
    TODO()
  }
}