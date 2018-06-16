package io.dwak.squiggly.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "story")
data class DbStory(
   @PrimaryKey val id: String
)
