package io.dwak.squiggly.inject

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.dwak.squiggly.common.ModelType
import io.dwak.squiggly.transformer.CommentTransformer
import io.dwak.squiggly.transformer.StoryTransformer
import io.dwak.squiggly.transformer.Transformer

@Module
abstract class ModelTransformerModule {

  @Binds @IntoMap @ModelKey(ModelType.STORY)
  abstract fun bindsStoryTransformer(storyTransformer: StoryTransformer): Transformer<*, *, *>

  @Binds @IntoMap @ModelKey(ModelType.COMMENT)
  abstract fun bindsCommentTransformer(commentTransformer: CommentTransformer): Transformer<*, *, *>
}