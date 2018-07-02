package io.dwak.squigglyreader

import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.preference.PreferenceDataStore
import androidx.preference.PreferenceManager
import butterknife.BindView
import butterknife.ButterKnife
import javax.inject.Inject

class MainActivity : BaseActivity() {
  @BindView(R.id.test) lateinit var test: Button
  @Inject lateinit var factory: ViewModelProvider.Factory
  @Inject lateinit var prefDataStore: PreferenceDataStore

  private lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    ButterKnife.bind(this)

    viewModel = ViewModelProviders.of(this, factory)[MainViewModel::class.java]

    prefDataStore.putBoolean("foo", true)
  }
}