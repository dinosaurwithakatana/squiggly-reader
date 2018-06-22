package io.dwak.squigglyreader.inject.key

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class ViewModelKey(
    val value: KClass<out ViewModel>
)
