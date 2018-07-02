package io.dwak.squiggly.db.dao

import androidx.room.*
import io.dwak.squiggly.common.interfaces.SquigglyDao
import io.dwak.squiggly.db.SquigglyDb
import io.dwak.squiggly.db.entity.DbUser

@Dao
interface UserDao : SquigglyDao<DbUser> {
  @Query("SELECT * FROM user WHERE id LIKE :id")
  override fun get(id: String): DbUser?

  @Insert
  override fun insert(model: DbUser)

  @Update
  override fun update(model: DbUser)

  @Delete
  override fun delete(model: DbUser)
}