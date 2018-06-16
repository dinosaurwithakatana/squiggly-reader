package io.dwak.squiggly.db.converters

import androidx.room.TypeConverter
import org.threeten.bp.Instant

object TypeConverters{
  // CharSequence
  @JvmStatic @TypeConverter fun fromCharSequence(value: CharSequence): String = value.toString()
  @JvmStatic @TypeConverter fun toCharSequence(value: String): CharSequence = value

  // Instant
  @JvmStatic @TypeConverter fun fromInstant(value: Instant): String = value.toString()
  @JvmStatic @TypeConverter fun toInstant(value: String): Instant = Instant.parse(value)

}