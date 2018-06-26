package io.dwak.squiggly.transformer

import io.dwak.squiggly.db.entity.DbUser
import io.dwak.squiggly.model.ApiUser
import io.dwak.squiggly.model.UiUser
import org.threeten.bp.Instant

object UserTransformer: Transformer<ApiUser, DbUser, UiUser> {
  override fun ApiUser.transformToDb(): DbUser {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun DbUser.transformToApi(): ApiUser {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun DbUser.transformToUi() = UiUser(
      id = id,
      name = username
  )

  override fun UiUser.transformToDb() = DbUser(
      id = id,
      username = name,
      registeredDate = Instant.now()
  )
}