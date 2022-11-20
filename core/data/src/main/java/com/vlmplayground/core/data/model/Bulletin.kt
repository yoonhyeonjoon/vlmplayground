
package com.vlmplayground.core.data.model

import com.vlmplayground.core.database.model.BulletinEntity
import com.vlmplayground.core.model.data.Bulletin

fun Bulletin.asEntity() = BulletinEntity(
    id = wid,
    title   = title,
    text    = text,
    imageUrl = imageUrl,
    author  = author,
)
