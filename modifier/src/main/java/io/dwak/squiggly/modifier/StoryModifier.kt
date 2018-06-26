package io.dwak.squiggly.modifier

import android.util.Log
import io.dwak.squiggly.db.dao.StoryDao
import io.dwak.squiggly.transformer.StoryTransformer.transformToDb
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.reactive.awaitFirst
import kotlinx.coroutines.experimental.reactive.awaitSingle
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StoryModifier @Inject constructor(private val storyDao: StoryDao) : Modifier {

  override fun submit(mod: Modification) {
    when (mod) {
      is Modification.SubmitStory -> {
        launch { storyDao.insertStory(mod.uiStory.transformToDb()) }
      }
      is Modification.TagStory -> {
      }
      is Modification.VoteOnStory -> {
        launch {
          storyDao.updateStory(
              storyDao.getStory(mod.storyId)
                  .awaitFirst()
                  .let { it.copy(voteCount = if (mod.increment) it.voteCount + 1 else it.voteCount - 1) }
          )
        }
      }
      else -> error("not a story")
    }
  }
}