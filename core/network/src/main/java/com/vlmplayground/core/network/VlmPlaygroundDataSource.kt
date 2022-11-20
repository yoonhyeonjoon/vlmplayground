package com.vlmplayground.core.network

import com.vlmplayground.core.network.model.NetworkBulletin

interface VlmPlaygroundDataSource {
    suspend fun getBulletin(): List<NetworkBulletin>

}