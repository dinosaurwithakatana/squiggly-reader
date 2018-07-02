package io.dwak.squiggly.prefs.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "string")
data class DbString(
    @PrimaryKey val id: String,
    val value: String?
)

@Entity(tableName = "boolean")
data class DbBoolean(
    @PrimaryKey val id: String,
    val value: Boolean
)

@Entity(tableName = "integer")
data class DbInteger(
    @PrimaryKey val id: String,
    val value: Int
)

@Entity(tableName = "long")
data class DbLong(
    @PrimaryKey val id: String,
    val value: Long
)

@Entity(tableName = "float")
data class DbFloat(
    @PrimaryKey val id: String,
    val value: Float
)
