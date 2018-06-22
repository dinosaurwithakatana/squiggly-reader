package io.dwak.squiggly.db.dao

import androidx.room.Dao
import androidx.room.Insert
import io.dwak.squiggly.db.entity.DbStory

@Dao
interface StoryDao {
  @Insert fun insertStory(dbStory: DbStory)
}