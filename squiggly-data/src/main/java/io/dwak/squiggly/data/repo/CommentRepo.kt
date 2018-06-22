package io.dwak.squiggly.data.repo

import io.dwak.squiggly.data.model.UiComment
import io.dwak.squiggly.data.transformer.toDbComment
import io.dwak.squiggly.data.transformer.toUiComment
import io.dwak.squiggly.db.dao.CommentDao
import io.dwak.squiggly.services.CommentService
import kotlinx.coroutines.experimental.channels.map
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.reactive.openSubscription
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