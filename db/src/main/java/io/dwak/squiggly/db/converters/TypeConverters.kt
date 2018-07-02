package io.dwak.squiggly.db.converters

import androidx.room.TypeConverter
import io.dwak.squiggly.common.ModelType
import io.dwak.squiggly.db.entity.UploadType
import org.threeten.bp.Instant

object TypeConverters {
  // CharSequence
  @JvmStatic
  @TypeConverter
  fun fromCharSequence(value: CharSequence?): String? = value?.toString()

  @JvmStatic
  @TypeConverter
  fun toCharSequence(value: String?): CharSequence? = value

  // Instant
  @JvmStatic
  @TypeConverter
  fun fromInstant(value: Instant): String = value.toString()

  @JvmStatic
  @TypeConverter
  fun toInstant(value: String): Instant = Instant.parse(value)

  @JvmStatic
  @TypeConverter
  fun fromModelType(value: ModelType): String = value.name

  @JvmStatic
  @TypeConverter
  fun toModelType(value: String): ModelType = ModelType.valueOf(value)

  @JvmStatic
  @TypeConverter
  fun fromUploadType(value: UploadType): String = value.name

  @JvmStatic
  @TypeConverter
  fun toUploadType(value: String): UploadType = UploadType.valueOf(value)
}