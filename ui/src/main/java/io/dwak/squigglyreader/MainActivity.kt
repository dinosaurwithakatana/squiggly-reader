package io.dwak.squigglyreader

import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import butterknife.BindView
import butterknife.ButterKnife
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.experimental.launch
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity() {
  @BindView(R.id.test) lateinit var test: Button
  @Inject lateinit var factory: ViewModelProvider.Factory

  private lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    ButterKnife.bind(this)

    viewModel = ViewModelProviders.of(this, factory)[MainViewModel::class.java]

    viewModel.comment.observe(this, Observer {
      Timber.d("$it")
    })

    viewModel.story.observe {
      Timber.d("$it")
    }

    viewModel.requestComment()

    val storyId = "0dec1ba9-e133-4e8d-99da-6fa016bf4bb6"
    launch {
      viewModel.requestStory(storyId)
    }

    test.setOnClickListener {
      viewModel.upvote(storyId)
    }
  }
}