package io.dwak.squiggly.db.dao

import androidx.room.Dao
import androidx.room.Insert
import io.dwak.squiggly.db.entity.DbUser

@Dao
interface UserDao {
  @Insert fun insertUser(dbUser: DbUser)
}