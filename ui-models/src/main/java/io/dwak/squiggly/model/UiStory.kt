package io.dwak.squiggly.model

import io.dwak.squiggly.common.interfaces.model.UiModel
import io.dwak.squiggly.common.newId

data class UiStory (
    val id: String = newId(),
    val link: String? = null,
    val content: CharSequence? = null,
    val group: String,
    val author: UiUser,
    val voteCount: Int
) : UiModel
