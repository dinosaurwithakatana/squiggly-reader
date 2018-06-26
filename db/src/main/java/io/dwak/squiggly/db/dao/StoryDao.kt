package io.dwak.squiggly.db.dao

import androidx.room.*
import io.dwak.squiggly.db.entity.DbStory
import io.dwak.squiggly.db.entity.DbStoryWithUser
import io.reactivex.Flowable

@Dao
interface StoryDao {
  @Insert
  fun insertStory(dbStory: DbStory)

  @Update
  fun updateStory(dbStory: DbStory)

  @Query("SELECT * FROM story WHERE id=:id")
  fun getStory(id: String): Flowable<DbStory>

  @Transaction
  @Query("SELECT * FROM story WHERE id=:id")
  fun getStoryWithUser(id: String): Flowable<DbStoryWithUser>
}