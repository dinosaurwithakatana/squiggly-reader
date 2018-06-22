package io.dwak.squiggly.model

import io.dwak.squiggly.common.interfaces.model.UiModel

data class UiComment(
    val id: String,
    val content: String
) : UiModel