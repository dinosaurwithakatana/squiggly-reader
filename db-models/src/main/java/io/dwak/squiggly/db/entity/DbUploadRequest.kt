package io.dwak.squiggly.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.dwak.squiggly.common.ModelType
import io.dwak.squiggly.common.interfaces.model.DbModel

@Entity(tableName = "upload_request")
data class DbUploadRequest(
    @PrimaryKey val id: String,
    val modelType: ModelType,
    val entityId: String,
    val uploadType: UploadType
) : DbModel

enum class UploadType {
  CREATE, UPDATE, DELETE
}
