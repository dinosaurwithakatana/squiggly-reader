package io.dwak.squiggly.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.dwak.squiggly.common.interfaces.model.DbModel

@Entity(tableName = "tag")
data class DbTag(
    @PrimaryKey @ColumnInfo(name = "name") val name: String
): DbModel
