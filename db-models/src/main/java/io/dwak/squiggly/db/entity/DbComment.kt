package io.dwak.squiggly.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import io.dwak.squiggly.common.interfaces.model.DbModel
import org.threeten.bp.Instant

@Entity(
    tableName = "comment",
    foreignKeys = [
      ForeignKey(
          entity = DbStory::class,
          parentColumns = ["id"],
          childColumns = ["storyId"]
      ),
      ForeignKey(
          entity = DbUser::class,
          parentColumns = ["username"],
          childColumns = ["poster"]
      )
    ]
)
data class DbComment(
    @ColumnInfo(name = "storyId") val storyId: String,

    @PrimaryKey val id: String,
    @ColumnInfo(name = "poster") val poster: String,
    @ColumnInfo(name = "postedTime") val postedTime: Instant,
    @ColumnInfo(name = "permalink") val permalink: String,
    @ColumnInfo(name = "voteCount") val voteCount: Int,
    @ColumnInfo(name = "parentId") val parentId: String? = null,
    @ColumnInfo(name = "content") val content: CharSequence
): DbModel