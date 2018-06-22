package io.dwak.squiggly.modifier

import io.dwak.squiggly.db.dao.CommentDao
import io.dwak.squiggly.db.dao.StoryDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StoryModifier @Inject constructor(
    private val storyDao: StoryDao,
    private val commentDao: CommentDao
): Modifier {

  override fun submit(mod: Modification) {
    when(mod) {
      is Modification.SubmitStory -> {}
      is Modification.TagStory -> {}
      is Modification.VoteOnStory -> {}

      is Modification.SubmitComment -> {}
      is Modification.VoteOnComment -> {}
    }
  }
}