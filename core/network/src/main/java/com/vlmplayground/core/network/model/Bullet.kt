package com.vlmplayground.core.network.model

import com.google.firebase.Timestamp
import com.vlmplayground.core.model.data.Bulletin
import kotlinx.serialization.Serializable
import java.util.*


//@Serializable
data class NetworkBulletin(
    var fid: String = "",
    var images: List<String> = listOf<String>(),
    var date: Date = Date(),
    var score: Long = 0L,
    var name: String = "",
    var text: String = "",
    var title: String = ""
)

fun NetworkBulletin.asExternalModel() = Bulletin(
     fid= fid,
     images= images,
     date = date,
     score= score,
     name = name,
     text = text,
     title = title)
