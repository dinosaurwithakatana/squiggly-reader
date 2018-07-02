package io.dwak.squiggly.prefs

import android.content.Context
import android.os.Debug
import androidx.preference.PreferenceDataStore
import androidx.room.Room
import io.dwak.squiggly.prefs.models.*


class DbPreferenceDataStore(private val context: Context) : PreferenceDataStore() {

  private val dao: PreferenceDao =
      Room.databaseBuilder(context, PreferenceDb::class.java, "prefs")
          .fallbackToDestructiveMigration()
          .apply { if (Debug.isDebuggerConnected()) allowMainThreadQueries() }
          .build().prefsDao()

  override fun getBoolean(key: String, defValue: Boolean): Boolean =
      dao.getBoolean(key)?.value ?: defValue

  override fun putLong(key: String, value: Long) = dao.insertLong(DbLong(key, value))

  override fun putInt(key: String, value: Int) = dao.insertInt(DbInteger(key, value))

  override fun getInt(key: String, defValue: Int): Int = dao.getInteger(key)?.value ?: defValue

  override fun putBoolean(key: String, value: Boolean) = dao.insertBoolean(DbBoolean(key, value))

  override fun getLong(key: String, defValue: Long): Long = dao.getLong(key)?.value ?: defValue

  override fun getFloat(key: String, defValue: Float): Float = dao.getFloat(key)?.value ?: defValue

  override fun putFloat(key: String, value: Float) = dao.insertFloat(DbFloat(key, value))

  override fun getString(key: String, defValue: String?): String? =
      dao.getString(key)?.value ?: defValue

  override fun putString(key: String, value: String?) = dao.insertString(DbString(key, value))


  override fun putStringSet(key: String?, values: MutableSet<String>?) {
    super.putStringSet(key, values)
  }

  override fun getStringSet(key: String?, defValues: MutableSet<String>?): MutableSet<String>? {
    return super.getStringSet(key, defValues)
  }
}