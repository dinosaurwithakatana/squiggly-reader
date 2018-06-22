package io.dwak.squigglyreader

import androidx.lifecycle.MutableLiveData
import io.dwak.squiggly.data.repo.CommentRepo
import io.dwak.squiggly.model.UiComment
import io.dwak.squigglyreader.util.MutableDelgate
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val commentRepo: CommentRepo) : BaseViewModel() {
  private val _comment = MutableLiveData<UiComment>()
  val comment by MutableDelgate(_comment)

  fun requestComment() {
    launch(parent = parent) { _comment.postValue(commentRepo.getComment("meow")) }
  }
}