package io.dwak.squiggly.db.inject.module

import android.content.Context
import android.os.Debug
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.dwak.squiggly.common.ModelType
import io.dwak.squiggly.common.interfaces.SquigglyDao
import io.dwak.squiggly.common.interfaces.model.DbModel
import io.dwak.squiggly.db.SquigglyDb
import io.dwak.squiggly.db.dao.CommentDao
import io.dwak.squiggly.db.dao.StoryDao
import io.dwak.squiggly.db.dao.UserDao
import io.dwak.squiggly.db.inject.ModelKey
import javax.inject.Singleton

@Module
class DbModule {
  @Provides @Singleton
  fun providesDb(context: Context) = Room.databaseBuilder(context, SquigglyDb::class.java, "Squiggly")
      .fallbackToDestructiveMigration()
      .apply { if (Debug.isDebuggerConnected()) allowMainThreadQueries() }
      .build()

  @Provides fun storyDao(db: SquigglyDb): StoryDao = db.storyDao()

  @Provides fun commentDao(db: SquigglyDb): CommentDao = db.commentDao()

  @Provides fun userDao(db: SquigglyDb): UserDao = db.userDao()

  @Provides fun daoMap(storyDao: StoryDao,
                       commentDao: CommentDao,
                       userDao: UserDao)
      : @JvmSuppressWildcards Map<ModelType, SquigglyDao<out DbModel>> {
    return mapOf(
        ModelType.STORY to storyDao,
        ModelType.COMMENT to commentDao,
        ModelType.USER to userDao
    )
  }

  @Provides fun uploadDao(db: SquigglyDb) = db.uploadDao()
}