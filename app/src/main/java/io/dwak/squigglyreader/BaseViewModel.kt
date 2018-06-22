package io.dwak.squigglyreader

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.experimental.Job

abstract class BaseViewModel constructor(
    protected val parent: Job = Job()
) : ViewModel(){

  override fun onCleared() {
    super.onCleared()
    parent.cancel()
  }
}