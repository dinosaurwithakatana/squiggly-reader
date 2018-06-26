package io.dwak.squiggly.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.dwak.squiggly.db.entity.DbStory
import io.reactivex.Flowable

@Dao
interface StoryDao {
  @Insert fun insertStory(dbStory: DbStory)
  @Update fun updateStory(dbStory: DbStory)
  @Query("SELECT * FROM story WHERE id=:id")
  fun getStory(id: String): Flowable<DbStory>
}