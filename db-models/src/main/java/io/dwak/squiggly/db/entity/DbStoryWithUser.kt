package io.dwak.squiggly.db.entity

import androidx.room.Embedded
import androidx.room.Relation
import io.dwak.squiggly.common.interfaces.model.DbModel

data class DbStoryWithUser(
    @Embedded val story: DbStory
) : DbModel {
  @Relation(parentColumn = "original_poster", entityColumn = "id")
  lateinit var user: @JvmSuppressWildcards Set<DbUser>
}
