package io.dwak.squigglyreader

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
  @Inject lateinit var factory: ViewModelProvider.Factory
  lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    viewModel = ViewModelProviders.of(this, factory)[MainViewModel::class.java]

    viewModel.comment.observe(this, Observer {
      Timber.d("$it")
    })

    viewModel.requestComment()
  }
}