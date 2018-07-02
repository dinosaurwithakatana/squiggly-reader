package io.dwak.squiggly.repo.repo

import io.dwak.squiggly.db.dao.CommentDao
import io.dwak.squiggly.model.UiComment
import io.dwak.squiggly.services.CommentService
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject
import kotlin.coroutines.experimental.suspendCoroutine

class CommentRepo @Inject constructor(
    private val commentDao: CommentDao,
    private val commentService: CommentService
) : Repo {

  @Suppress("UNUSED_PARAMETER")
  suspend fun getComment(commentId: String) = suspendCoroutine<UiComment> {
    launch {
      it.resume(
          commentService.getComment(commentId)
              .await()
              .let { UiComment(it.id, it.content) }
      )
    }
  }
}