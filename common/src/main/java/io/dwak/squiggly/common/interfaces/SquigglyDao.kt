package io.dwak.squiggly.common.interfaces

import io.dwak.squiggly.common.interfaces.model.DbModel

interface SquigglyDao<T : DbModel> {
  fun insert(model: T)
  fun get(id: String): T?
  fun update(model: T)
  fun delete(model: T)
}
