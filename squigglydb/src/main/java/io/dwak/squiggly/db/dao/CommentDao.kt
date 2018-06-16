package io.dwak.squiggly.db.dao

import androidx.room.*
import io.dwak.squiggly.db.entity.DbComment
import io.reactivex.Flowable

@Dao
interface CommentDao {
  @Query("SELECT * FROM comment WHERE storyId LIKE :storyId")
  fun findCommentsForStory(storyId: String): Flowable<List<DbComment>>

  @Query("SELECT * FROM comment WHERE id LIKE :commentId")
  fun findCommentById(commentId: String): Flowable<DbComment>

  @Insert fun insertComment(comment: DbComment)

  @Update fun updateComment(vararg comments: DbComment)

  @Delete fun deleteComment(vararg comments: DbComment)
}