package io.dwak.squigglyreader

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import butterknife.ButterKnife
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  fun <T> LiveData<T>.observe(f: (T) -> Unit) {
    observe(this@BaseActivity, Observer {
      if (it != null) {
        f(it)
      }
    })
  }

  fun CharSequence.toast() = Toast.makeText(this@BaseActivity, this, Toast.LENGTH_SHORT).show()
}