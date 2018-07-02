package io.dwak.squiggly.prefs

import androidx.room.*
import io.dwak.squiggly.prefs.models.*

@Dao
interface PreferenceDao {
  @Insert fun insertString(value: DbString)
  @Query("SELECT * from string where id LIKE :key") fun getString(key: String): DbString?
  @Update fun updateString(value: DbString)
  @Delete fun deleteString(value: DbString)

  @Insert fun insertBoolean(value: DbBoolean)
  @Query("SELECT * from boolean where id LIKE :key") fun getBoolean(key: String): DbBoolean?
  @Update fun updateBoolean(value: DbBoolean)
  @Delete fun deleteBoolean(value: DbBoolean)

  @Insert fun insertInt(value: DbInteger)
  @Query("SELECT * from integer where id LIKE :key") fun getInteger(key: String): DbInteger?
  @Update fun updateInt(value: DbInteger)
  @Delete fun deleteInt(value: DbInteger)

  @Insert fun insertLong(value: DbLong)
  @Query("SELECT * from long where id LIKE :key") fun getLong(key: String): DbLong?
  @Update fun updateLong(value: DbLong)
  @Delete fun deleteLong(value: DbLong)

  @Insert fun insertFloat(value: DbFloat)
  @Query("SELECT * from float where id LIKE :key") fun getFloat(key: String): DbFloat?
  @Update fun updateFloat(value: DbFloat)
  @Delete fun deleteFloat(value: DbFloat)
}