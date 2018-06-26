package io.dwak.squiggly.modifier

import javax.inject.Inject

class SquigglyModifier @Inject constructor(
    private val storyModifier: StoryModifier,
    private val commentModifier: CommentModifier,
    private val userModifier: UserModifier
) : Modifier {
  override fun submit(mod: Modification) {
    when (mod) {
      is Modification.SubmitStory -> storyModifier.submit(mod)
      is Modification.VoteOnStory -> storyModifier.submit(mod)
      is Modification.TagStory -> storyModifier.submit(mod)

      is Modification.SubmitComment-> commentModifier.submit(mod)
      is Modification.VoteOnComment -> commentModifier.submit(mod)

      is Modification.CreateUser -> userModifier.submit(mod)
    }
  }
}