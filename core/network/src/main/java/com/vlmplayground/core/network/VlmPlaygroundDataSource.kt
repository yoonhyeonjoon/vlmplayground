package com.vlmplayground.core.network

import com.vlmplayground.core.network.model.NetworkBulletin
import kotlinx.coroutines.flow.Flow

interface VlmPlaygroundDataSource {

//    fun getAllBulletin(): Flow<NetworkBulletin>

    //시간변환 : 5일치 : +432000_000, 1일치 +86400_000, 밀리세컨드로 계산됨
    //movePoint 432000_000로 설정한다면, 밀리세컨드로해서 -5일전까지부터의 데이터를 쿼링해옴
    fun getBulletinByTimestamp(movePoint: Long = 0L): Flow<List<NetworkBulletin>>

    fun deleteBulletin(fid : String)

    suspend fun insertOrIgnoreBulletins(entities: List<NetworkBulletin>) : Boolean

}