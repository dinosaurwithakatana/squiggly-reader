package io.dwak.squiggly.modifier

import io.dwak.squiggly.model.UiComment
import io.dwak.squiggly.model.UiStory

sealed class Modification {
  data class SubmitStory(val uiStory: UiStory) : Modification()
  data class VoteOnStory(val storyId: String, val increment: Boolean = true) : Modification()
  data class TagStory(val storyId: String, val tagId: String) : Modification()

  data class SubmitComment(
      val storyId: String,
      val parentCommentId: String? = null,
      val uiComment: UiComment
      ) : Modification()

  data class VoteOnComment(val commentId: String, val increment: Boolean = true) : Modification()
}