package com.vlmplayground.core.data.repository

import com.vlmplayground.core.data.model.asEntity
import com.vlmplayground.core.data.util.suspendRunCatching
import com.vlmplayground.core.database.dao.BulletinBoardDao
import com.vlmplayground.core.database.model.BulletinEntity
import com.vlmplayground.core.database.model.asDataModel
import com.vlmplayground.core.model.data.Bulletin
import com.vlmplayground.core.network.firebase.FirebaseNetworkDataSource
import com.vlmplayground.core.network.model.NetworkBulletin
import com.vlmplayground.core.network.model.asDataModel
import com.vlmplayground.core.network.model.asNetworkBulletin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import java.util.*
import javax.inject.Inject



class OfflineFirstBulletinRepository @Inject constructor(
    private val bulletinBoardDao: BulletinBoardDao,
    private val firebaseNetworkDataSource : FirebaseNetworkDataSource,
) : BulletinRepository {

    override fun syncBulletinBoard(): Flow<Unit> =
        firebaseNetworkDataSource.getBulletinByTimestamp(movePoint = 432000_000)
        .map { bulletinList ->
            //newly data to Room
            bulletinBoardDao.upsertBulletin(entities = bulletinList.map{ networkBulletin ->
                networkBulletin.asDataModel().asEntity()
            })
        }

    //upload
    override suspend fun uploadToBulletinBoard(newBulletin : Bulletin) {
        bulletinBoardDao.insertOrIgnoreBulletin(newBulletin.asEntity())
        val getBulletinList: List<BulletinEntity> = bulletinBoardDao.getUnsyncedBulletin().first()

        val insertingResult = firebaseNetworkDataSource.insertOrIgnoreBulletins(
            entities = getBulletinList.map{it.asDataModel().asNetworkBulletin()}
        )

        if(insertingResult)
        {
            getBulletinList.forEach { it.synced = true }
        }

        bulletinBoardDao.updateBulletin(entities = getBulletinList)

        val fff = 1

    }
}



