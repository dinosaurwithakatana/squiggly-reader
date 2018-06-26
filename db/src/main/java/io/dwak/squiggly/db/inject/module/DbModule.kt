package io.dwak.squiggly.db.inject.module

import android.content.Context
import android.os.Debug
import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.dwak.squiggly.db.SquigglyDb
import javax.inject.Singleton

@Module
class DbModule {
  @Provides @Singleton
  fun providesDb(context: Context) = Room.databaseBuilder(context, SquigglyDb::class.java, "Squiggly")
      .fallbackToDestructiveMigration()
      .apply { if (Debug.isDebuggerConnected()) allowMainThreadQueries() }
      .build()

  @Provides fun storyDao(db: SquigglyDb) = db.storyDao()

  @Provides fun commentDao(db: SquigglyDb) = db.commentDao()

  @Provides fun userDao(db: SquigglyDb) = db.userDao()
}