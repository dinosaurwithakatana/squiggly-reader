package io.dwak.squigglyreader

import androidx.lifecycle.MutableLiveData
import io.dwak.squiggly.common.newId
import io.dwak.squiggly.data.repo.CommentRepo
import io.dwak.squiggly.model.UiComment
import io.dwak.squiggly.model.UiStory
import io.dwak.squiggly.model.UiUser
import io.dwak.squiggly.modifier.Modification
import io.dwak.squiggly.modifier.Modifier
import io.dwak.squigglyreader.util.MutableDelgate
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val commentRepo: CommentRepo,
    private val modifier: Modifier
) : BaseViewModel() {

  private val _comment = MutableLiveData<UiComment>()
  val comment by MutableDelgate(_comment)
  val stories: List<UiStory>

  init {
    val author1 = UiUser(name = "vishnulol")
    val author2 = UiUser(name = "vishnu")

    modifier.run {
      submit(Modification.CreateUser(author1))
      submit(Modification.CreateUser(author2))
    }

    stories = (1..100).map {
      if (it.rem(2) == 0) {
        UiStory(link = "www.google.com",
            group = "tildes",
            author = author1
        )
      }
      else {
        UiStory(content = "blah blah blah",
            group = "tildes",
            author = author2
        )
      }
    }
    stories.forEach {
      modifier.submit(Modification.SubmitStory(it))
    }
  }

  fun requestComment() {
    launch(parent = parent) { _comment.postValue(commentRepo.getComment("meow")) }
  }

  fun upvote(storyId: String) = modifier.submit(Modification.VoteOnStory(storyId, true))
  fun downvote(storyId: String) = modifier.submit(Modification.VoteOnStory(storyId, false))
}