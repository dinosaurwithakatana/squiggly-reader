package io.dwak.squiggly.inject

import dagger.Binds
import dagger.Module
import io.dwak.squiggly.modifier.Modifier
import io.dwak.squiggly.modifier.SquigglyModifier

@Module
abstract class ModifierModule {
  @Binds abstract fun modifier(squigglyModifier: SquigglyModifier): Modifier
}