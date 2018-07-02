package io.dwak.squiggly.prefs

import androidx.room.*
import io.dwak.squiggly.prefs.models.*

@Dao
interface PreferenceDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertString(value: DbString)
  @Query("SELECT * from string where id LIKE :key") fun getString(key: String): DbString?
  @Delete fun deleteString(value: DbString)

  @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertBoolean(value: DbBoolean)
  @Query("SELECT * from boolean where id LIKE :key") fun getBoolean(key: String): DbBoolean?
  @Delete fun deleteBoolean(value: DbBoolean)

  @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertInt(value: DbInteger)
  @Query("SELECT * from integer where id LIKE :key") fun getInteger(key: String): DbInteger?
  @Delete fun deleteInt(value: DbInteger)

  @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertLong(value: DbLong)
  @Query("SELECT * from long where id LIKE :key") fun getLong(key: String): DbLong?
  @Delete fun deleteLong(value: DbLong)

  @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertFloat(value: DbFloat)
  @Query("SELECT * from float where id LIKE :key") fun getFloat(key: String): DbFloat?
  @Delete fun deleteFloat(value: DbFloat)
}