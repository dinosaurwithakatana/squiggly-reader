package io.dwak.squiggly.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.Instant

@Entity(tableName = "user")
data class DbUser(
    @PrimaryKey @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "registeredDate") val registeredDate: Instant
)