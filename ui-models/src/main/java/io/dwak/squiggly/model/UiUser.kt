package io.dwak.squiggly.model

import io.dwak.squiggly.common.interfaces.model.UiModel
import io.dwak.squiggly.common.newId

data class UiUser(
    val id: String = newId(),
    val name: String
): UiModel
