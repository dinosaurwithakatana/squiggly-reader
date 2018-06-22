package io.dwak.squiggly.services.model

import io.dwak.squiggly.common.interfaces.model.ApiModel

data class ApiComment(
    val id: String,
    val content: String
): ApiModel
