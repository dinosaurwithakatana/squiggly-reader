package io.dwak.squigglyreader

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import io.dwak.squiggly.data.repo.CommentRepo
import io.dwak.squiggly.fetcher.Fetcher
import io.dwak.squiggly.modifier.Modifier
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import timber.log.Timber
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
  @Inject lateinit var commentRepo: CommentRepo
  @Inject lateinit var fetcher: Fetcher
  @Inject lateinit var modifier: Modifier

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    launch {
      val comment = commentRepo.getComment("meow")

      withContext(UI) {
        Log.d("Meow", "$comment")
      }
    }
  }
}