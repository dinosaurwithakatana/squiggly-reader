package io.dwak.squiggly.uploader

import io.dwak.squiggly.common.ModelType
import io.dwak.squiggly.common.interfaces.SquigglyDao
import io.dwak.squiggly.common.interfaces.model.DbModel
import io.dwak.squiggly.db.dao.CommentDao
import io.dwak.squiggly.db.dao.StoryDao
import io.dwak.squiggly.db.dao.UploadDao
import io.dwak.squiggly.db.entity.DbComment
import io.dwak.squiggly.db.entity.UploadType
import io.dwak.squiggly.services.CommentService
import io.dwak.squiggly.transformer.CommentTransformer.transformToApi
import kotlinx.coroutines.experimental.channels.map
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.reactive.openSubscription
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TildesUploader @Inject constructor(
    private val daos: @JvmSuppressWildcards Map<ModelType, SquigglyDao<out DbModel>>,
    private val uploadDao: UploadDao,
    private val commentService: CommentService
) : Uploader {

  init {
    data class UploadRequest(val modelType: ModelType,
                             val uploadType: UploadType,
                             val model: DbModel?)
    launch {
      val (modelType, uploadType, model) = uploadDao.getUploads()
          .openSubscription()
          .map {
            it.map {
              UploadRequest(it.modelType, it.uploadType, daos[it.modelType]?.get(it.entityId))
            }
          }
          .receive().first()

      when (modelType) {
        ModelType.COMMENT -> {
          val comment = (model as DbComment).transformToApi()
          commentService.postComment(comment)
        }
        else -> error("no service available for model")
      }

    }
  }
}