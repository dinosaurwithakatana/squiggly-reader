package io.dwak.squiggly.modifier

import io.dwak.squiggly.db.dao.StoryDao
import io.dwak.squiggly.transformer.StoryTransformer.transformToDb
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StoryModifier @Inject constructor(private val storyDao: StoryDao) : Modifier {

  override fun submit(mod: Modification) {
    when (mod) {
      is Modification.SubmitStory -> {
        storyDao.insertStory(mod.uiStory.transformToDb())
      }
      is Modification.TagStory -> {
      }
      is Modification.VoteOnStory -> {
      }
      else -> error("not a story")
    }
  }
}