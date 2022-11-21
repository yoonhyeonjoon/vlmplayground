package com.vlmplayground.core.network.model

import com.vlmplayground.core.model.data.Bulletin
import kotlinx.serialization.Serializable


//@Serializable
data class NetworkBulletin(
    val id: String? = null,
    val title: String? = null,
    val text: String? = null,
    val imageUrl: String? = null,
    val author: String? = null
)

fun NetworkBulletin.asExternalModel() = Bulletin(
    wid = id?:"null",
    title   = title?:"null",
    text    = text?:"null",
    imageUrl    = imageUrl?:"null",
    author  = author?:"null",
)
