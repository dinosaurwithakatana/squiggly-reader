package io.dwak.squigglyreader

import androidx.lifecycle.MutableLiveData
import io.dwak.squiggly.common.newId
import io.dwak.squiggly.data.RepoResponse
import io.dwak.squiggly.data.repo.CommentRepo
import io.dwak.squiggly.data.repo.StoryRepo
import io.dwak.squiggly.data.repo.StoryRepo_Factory
import io.dwak.squiggly.model.UiComment
import io.dwak.squiggly.model.UiStory
import io.dwak.squiggly.model.UiUser
import io.dwak.squiggly.modifier.Modification
import io.dwak.squiggly.modifier.Modifier
import io.dwak.squigglyreader.util.MutableDelgate
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val commentRepo: CommentRepo,
    private val storyRepo: StoryRepo,
    private val modifier: Modifier
) : BaseViewModel() {

  private val _comment = MutableLiveData<UiComment>()
  val comment by MutableDelgate(_comment)

  private val _story = MutableLiveData<UiStory>()
  val story by MutableDelgate(_story)

  private val _error = MutableLiveData<String>()
  val error by MutableDelgate(_error)

  suspend fun requestStory(storyId: String) = storyRepo.getStory(storyId).consumeEach {
    when (it) {
      is RepoResponse.Success<UiStory> -> _story.postValue(it.model)
      is RepoResponse.NotFound -> _error.postValue("Story not found")
    }
  }

  fun requestComment() {
    launch(parent = parent) { _comment.postValue(commentRepo.getComment("meow")) }
  }

  fun upvote(storyId: String) = modifier.submit(Modification.VoteOnStory(storyId, true))
  fun downvote(storyId: String) = modifier.submit(Modification.VoteOnStory(storyId, false))
}