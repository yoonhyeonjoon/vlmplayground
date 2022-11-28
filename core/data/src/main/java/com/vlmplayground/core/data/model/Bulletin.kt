
package com.vlmplayground.core.data.model

import com.vlmplayground.core.database.model.BulletinEntity
import com.vlmplayground.core.model.data.Bulletin

fun Bulletin.asEntity(synced: Boolean = false, requestoption : String = "dry") = BulletinEntity(
    fid = fid,
    images = images.reduce{ s: String, s1: String -> "$s,$s1" },
    date = date,
    score = score.toString(),
    name = name,
    text = text,
    title = title,
    synced = synced,
    requestoption = requestoption
)

