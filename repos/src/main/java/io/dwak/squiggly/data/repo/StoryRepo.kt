package io.dwak.squiggly.data.repo

import io.dwak.squiggly.db.dao.StoryDao
import javax.inject.Inject

class StoryRepo @Inject constructor(private val storyDao: StoryDao): Repo{
}