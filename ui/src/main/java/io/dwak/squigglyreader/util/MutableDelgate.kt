package io.dwak.squigglyreader.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.reflect.KProperty

class MutableDelgate<T>(private val mutableLiveData: MutableLiveData<T>) {
  operator fun getValue(thisRef: Any, property: KProperty<*>): LiveData<T> = mutableLiveData
}