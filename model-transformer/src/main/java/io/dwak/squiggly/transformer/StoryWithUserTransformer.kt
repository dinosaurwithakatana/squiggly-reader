package io.dwak.squiggly.transformer

import io.dwak.squiggly.db.entity.DbStoryWithUser
import io.dwak.squiggly.model.UiStory
import io.dwak.squiggly.transformer.UserTransformer.transformToUi

object StoryWithUserTransformer : Transformer<Nothing, DbStoryWithUser, UiStory>{
  override fun Nothing.transformToDb() = error("not supported")
  override fun DbStoryWithUser.transformToApi() = error("not supported")
  override fun UiStory.transformToDb(): DbStoryWithUser = error("not supported")

  override fun DbStoryWithUser.transformToUi() = UiStory(
      id = story.id,
      link = story.link,
      content = story.content,
      group = story.subgroup,
      voteCount = story.voteCount,
      author = user.first().transformToUi()
  )
}