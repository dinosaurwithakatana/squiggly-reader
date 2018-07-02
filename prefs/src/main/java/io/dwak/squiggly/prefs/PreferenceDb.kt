package io.dwak.squiggly.prefs

import androidx.room.Database
import androidx.room.RoomDatabase
import io.dwak.squiggly.prefs.models.*

@Database(
    entities = [
      DbString::class,
      DbInteger::class,
      DbLong::class,
      DbBoolean::class,
      DbFloat::class
    ],
    version = 1
)
abstract class PreferenceDb : RoomDatabase() {
  abstract fun prefsDao(): PreferenceDao
}
