package io.dwak.squiggly.transformer

import io.dwak.squiggly.db.entity.DbStory
import io.dwak.squiggly.model.ApiStory
import io.dwak.squiggly.model.UiStory
import org.threeten.bp.Instant

object StoryTransformer : Transformer<ApiStory, DbStory, UiStory> {
  override fun ApiStory.transformToDb(): DbStory = TODO()
  override fun DbStory.transformToApi(): ApiStory = TODO()

  override fun DbStory.transformToUi(): UiStory = TODO()
//      UiStory(
//      id = id,
//      link = link,
//      content = content,
//      author = originalPoster
//  )

  override fun UiStory.transformToDb(): DbStory = DbStory(
      id = id,
      subgroup = group,
      postedTime = Instant.now(),
      content = content,
      originalPoster = author.id,
      voteCount = voteCount,
      link = link
  )
}