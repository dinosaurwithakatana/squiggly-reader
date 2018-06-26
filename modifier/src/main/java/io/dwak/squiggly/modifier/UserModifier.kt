package io.dwak.squiggly.modifier

import io.dwak.squiggly.db.dao.UserDao
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject
import javax.inject.Singleton
import io.dwak.squiggly.transformer.UserTransformer.transformToDb

@Singleton
class UserModifier @Inject constructor(private val userDao: UserDao): Modifier {
  override fun submit(mod: Modification) {
    when (mod) {
      is Modification.CreateUser -> {
        launch { userDao.insertUser(mod.user.transformToDb()) }
      }
      else -> error("not handled here")
    }
  }
}