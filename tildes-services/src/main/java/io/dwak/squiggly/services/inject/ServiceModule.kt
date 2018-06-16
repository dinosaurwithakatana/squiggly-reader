package io.dwak.squiggly.services.inject

import dagger.Module
import dagger.Provides
import io.dwak.squiggly.services.CommentService
import io.dwak.squiggly.services.model.ApiComment
import io.reactivex.Flowable

@Module
class ServiceModule {
  @Provides fun commentService() = object: CommentService {
    override fun getComment(commentId: String): Flowable<ApiComment> {
      return Flowable.just(ApiComment())
    }

  }
}