package io.dwak.squiggly.db.dao

import androidx.room.*
import io.dwak.squiggly.common.interfaces.SquigglyDao
import io.dwak.squiggly.db.entity.DbStory
import io.dwak.squiggly.db.entity.DbStoryWithUser
import io.reactivex.Flowable

@Dao
interface StoryDao : SquigglyDao<DbStory> {
  @Insert
  fun insertStory(dbStory: DbStory)

  @Update
  fun updateStory(dbStory: DbStory)

  @Query("SELECT * FROM story WHERE id=:id")
  fun getStory(id: String): Flowable<DbStory>

  @Transaction
  @Query("SELECT * FROM story WHERE id=:id")
  fun getStoryWithUser(id: String): Flowable<DbStoryWithUser>

  @Query("SELECT * FROM story WHERE id=:id")
  override fun get(id: String): DbStory?

  @Insert
  override fun insert(model: DbStory)

  @Update
  override fun update(model: DbStory)

  @Delete
  override fun delete(model: DbStory)
}