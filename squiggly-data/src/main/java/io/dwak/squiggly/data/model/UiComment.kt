package io.dwak.squiggly.data.model

import io.dwak.squiggly.common.interfaces.model.UiModel

data class UiComment(
    val id: String,
    val content: String
) : UiModel