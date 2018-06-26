package io.dwak.squigglyreader.inject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.dwak.squigglyreader.inject.scope.ActivityScope
import javax.inject.Inject
import javax.inject.Provider

@ActivityScope
class DaggerViewModelFactory @Inject constructor(
    private val viewModelMap: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel?> create(modelClass: Class<T>) = viewModelMap[modelClass]!!.get() as T
}