package com.vlmplayground.core.network.model

import kotlinx.serialization.Serializable


@Serializable
data class NetworkBulletin(
    val id: String,
    val title: String,
    val text: String,
    val imageUrl: String,
    val author: String
)