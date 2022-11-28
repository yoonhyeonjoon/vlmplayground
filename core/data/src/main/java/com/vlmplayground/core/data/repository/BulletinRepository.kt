

package com.vlmplayground.core.data.repository

import com.vlmplayground.core.model.data.Bulletin
import kotlinx.coroutines.flow.Flow

interface BulletinRepository {

    fun syncBulletinBoardtoLocal() : Flow<Unit>

    suspend fun uploadBulletin(newBulletin: Bulletin): Boolean

    suspend fun deleteBulletin(newBulletin: List<Bulletin>): Boolean

    suspend fun editBulletin(targetBulletin: Bulletin): Boolean

}
