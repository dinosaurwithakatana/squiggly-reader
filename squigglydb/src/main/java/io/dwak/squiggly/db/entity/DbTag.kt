package io.dwak.squiggly.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tag")
data class DbTag(
    @PrimaryKey @ColumnInfo(name = "name") val name: String
)
