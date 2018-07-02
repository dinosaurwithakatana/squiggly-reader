package io.dwak.squiggly.repo.repo

import io.dwak.squiggly.repo.RepoResponse
import io.dwak.squiggly.db.dao.StoryDao
import io.dwak.squiggly.model.UiStory
import io.dwak.squiggly.transformer.StoryWithUserTransformer.transformToUi
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.map
import kotlinx.coroutines.experimental.reactive.openSubscription
import javax.inject.Inject

class StoryRepo @Inject constructor(private val storyDao: StoryDao) : Repo {
  fun getStory(storyId: String): ReceiveChannel<RepoResponse<UiStory>>
      = storyDao.getStoryWithUser(storyId)
      .openSubscription()
      .map {
        when {
          it != null -> RepoResponse.Success(it.transformToUi())
          else -> RepoResponse.NotFound<UiStory>()
        }
      }
}