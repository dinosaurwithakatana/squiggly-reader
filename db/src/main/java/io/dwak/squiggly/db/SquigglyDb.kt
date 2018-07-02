package io.dwak.squiggly.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.dwak.squiggly.db.dao.CommentDao
import io.dwak.squiggly.db.dao.StoryDao
import io.dwak.squiggly.db.dao.UploadDao
import io.dwak.squiggly.db.dao.UserDao
import io.dwak.squiggly.db.entity.DbComment
import io.dwak.squiggly.db.entity.DbStory
import io.dwak.squiggly.db.entity.DbUploadRequest
import io.dwak.squiggly.db.entity.DbUser

@TypeConverters(io.dwak.squiggly.db.converters.TypeConverters::class)
@Database(
    entities = [DbComment::class, DbStory::class, DbUser::class, DbUploadRequest::class],
    version = 5
)
abstract class SquigglyDb : RoomDatabase() {
  abstract fun storyDao(): StoryDao
  abstract fun userDao(): UserDao
  abstract fun commentDao(): CommentDao
  abstract fun uploadDao(): UploadDao
}