package io.dwak.squiggly.modifier

import io.dwak.squiggly.db.dao.StoryDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StoryModifier @Inject constructor(
    private val storyDao: StoryDao
): Modifier {
  override fun submit(mod: Modifications) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}