package io.dwak.squiggly.db.dao

import androidx.room.*
import io.dwak.squiggly.common.interfaces.SquigglyDao
import io.dwak.squiggly.db.entity.DbComment
import io.reactivex.Flowable

@Dao
interface CommentDao : SquigglyDao<DbComment> {
  @Query("SELECT * FROM comment WHERE storyId LIKE :storyId")
  fun findCommentsForStory(storyId: String): Flowable<List<DbComment>>

  @Query("SELECT * FROM comment WHERE storyId LIKE :id")
  override fun get(id: String): DbComment?

  @Insert
  override fun insert(model: DbComment)

  @Update
  override fun update(model: DbComment)

  @Delete
  override fun delete(model: DbComment)
}