package io.dwak.squiggly.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.dwak.squiggly.db.entity.DbUploadRequest
import io.reactivex.Flowable

@Dao
interface UploadDao {
  @Query("SELECT * FROM upload_request")
  fun getUploads(): Flowable<List<DbUploadRequest>>

  @Insert
  fun addUpload(dbUploadRequest: DbUploadRequest)

  @Delete
  fun deleteUpload(upload: DbUploadRequest)
}