package io.dwak.squiggly.transformer

import io.dwak.squiggly.db.entity.DbStory
import io.dwak.squiggly.model.ApiStory
import io.dwak.squiggly.model.UiStory

object StoryTransformer: Transformer<ApiStory, DbStory, UiStory> {
  override fun ApiStory.transformToDb(): DbStory = TODO()
  override fun DbStory.transformToApi(): ApiStory = TODO()
  override fun DbStory.transformToUi(): UiStory  = TODO()
  override fun UiStory.transformToDb(): DbStory  = TODO()
}