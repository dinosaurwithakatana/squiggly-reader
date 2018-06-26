package io.dwak.squiggly.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import io.dwak.squiggly.common.interfaces.model.DbModel
import org.threeten.bp.Instant

@Entity(
    tableName = "story",
    foreignKeys = [
      ForeignKey(
          entity = DbUser::class,
          parentColumns = ["id"],
          childColumns = ["original_poster"]
      )
    ]
)
data class DbStory(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "subgroup") val subgroup: String,
    @ColumnInfo(name = "original_poster") val originalPoster: String,
    @ColumnInfo(name = "posted_time") val postedTime: Instant,
    @ColumnInfo(name = "vote_count") val voteCount: Int,
    @ColumnInfo(name = "link") val link: String? = null,
    @ColumnInfo(name = "content") val content: CharSequence? = null
): DbModel
