package io.dwak.squigglyreader

import android.os.Bundle
import androidx.preference.PreferenceFragment
import io.dwak.squiggly.prefs.DbPreferenceDataStore

class PrefFrag : PreferenceFragment(){
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    preferenceManager.preferenceDataStore = DbPreferenceDataStore(activity)
    preferenceManager.preferenceDataStore?.putBoolean("foo", true)
  }
  override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
  }
}