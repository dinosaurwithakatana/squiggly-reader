package io.dwak.squiggly.inject

import dagger.Binds
import dagger.Module
import io.dwak.squiggly.modifier.Modifier
import io.dwak.squiggly.modifier.SquigglyModifier
import javax.inject.Singleton

@Module
abstract class ModifierModule {
  @Binds @Singleton abstract fun modifier(squigglyModifier: SquigglyModifier): Modifier
}