

package com.vlmplayground.core.data.repository

import com.vlmplayground.core.model.data.Bulletin
import kotlinx.coroutines.flow.Flow

interface BulletinRepository /*: Syncable*/ {
    fun syncBulletinBoard() : Flow<Unit>
    suspend fun uploadToBulletinBoard(newBulletin: Bulletin)
}
