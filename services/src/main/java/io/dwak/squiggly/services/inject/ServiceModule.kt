package io.dwak.squiggly.services.inject

import dagger.Module
import dagger.Provides
import io.dwak.squiggly.services.CommentService
import io.dwak.squiggly.model.ApiComment
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

@Module
class ServiceModule {
  @Provides
  fun commentService() = object : CommentService {
    override fun getComment(commentId: String): Deferred<ApiComment> = async {
      ApiComment("meow", "i'm a cat")
    }
  }
}