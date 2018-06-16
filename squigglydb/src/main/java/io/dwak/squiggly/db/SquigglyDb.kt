package io.dwak.squiggly.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.dwak.squiggly.db.dao.CommentDao
import io.dwak.squiggly.db.entity.DbComment
import io.dwak.squiggly.db.entity.DbStory

@TypeConverters(io.dwak.squiggly.db.converters.TypeConverters::class)
@Database(entities = [DbComment::class, DbStory::class], version = 1)
abstract class SquigglyDb : RoomDatabase(){
  abstract fun commentDao(): CommentDao
}