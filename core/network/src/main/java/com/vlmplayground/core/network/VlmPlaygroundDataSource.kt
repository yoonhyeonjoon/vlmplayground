package com.vlmplayground.core.network

import com.vlmplayground.core.network.model.NetworkBulletin
import kotlinx.coroutines.flow.Flow

interface VlmPlaygroundDataSource {
    suspend fun getBulletin(): Flow<NetworkBulletin>

}