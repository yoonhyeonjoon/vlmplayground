package com.vlmplayground.core.data.repository

import com.vlmplayground.core.data.model.asEntity
import com.vlmplayground.core.data.util.suspendRunCatching
import com.vlmplayground.core.database.dao.BulletinBoardDao
import com.vlmplayground.core.network.firebase.FirebaseNetworkDataSource
import com.vlmplayground.core.network.model.asDataModel
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




//    override fun getBulletinStream(): Flow<List<Bulletin>> =
//
////        bulletinBoardDao.getAllEntityStream().map { it.map(BulletinEntity::asExternalModel) }
//    firebaseNetworkDataSource.getBulletin().map { it.asExternalModel() }
////    override suspend fun syncWith(synchronizer: Synchronizer): Boolean =
////        synchronizer.changeListSync(
////
////      )

}



