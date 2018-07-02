package io.dwak.squiggly.modifier

import io.dwak.squiggly.db.dao.CommentDao
import javax.inject.Inject
import io.dwak.squiggly.transformer.CommentTransformer.transformToDb

class CommentModifier @Inject constructor(private val commentDao: CommentDao) : Modifier {
  override fun submit(mod: Modification) {
    when (mod) {
      is Modification.SubmitComment -> {
        commentDao.insert(mod.uiComment.transformToDb())
      }
      is Modification.VoteOnComment -> {
      }
      else -> error("not a comment")
    }
  }
}