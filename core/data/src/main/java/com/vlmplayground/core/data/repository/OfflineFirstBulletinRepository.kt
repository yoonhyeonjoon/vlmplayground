package com.vlmplayground.core.data.repository

import com.vlmplayground.core.database.dao.BulletinBoardDao
import com.vlmplayground.core.database.model.BulletinEntity
import com.vlmplayground.core.database.model.asExternalModel
import com.vlmplayground.core.model.data.Bulletin
import com.vlmplayground.core.network.firebase.FirebaseNetworkDataSource
import com.vlmplayground.core.network.model.asExternalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class OfflineFirstBulletinRepository @Inject constructor(
    private val bulletinBoardDao: BulletinBoardDao,
    private val firebaseNetworkDataSource : FirebaseNetworkDataSource,
) : BulletinRepository {
    override fun getBulletinStream(): Flow<List<Bulletin>> {
        TODO("Not yet implemented")
    }

    override fun getaBulletinStream(): Flow<Bulletin> =
        firebaseNetworkDataSource.getBulletin().map { it.asExternalModel() }


    //    override fun getBulletinStream(): Flow<List<Bulletin>> =
//
////        bulletinBoardDao.getAllEntityStream().map { it.map(BulletinEntity::asExternalModel) }
//    firebaseNetworkDataSource.getBulletin().map { it.asExternalModel() }
////    override suspend fun syncWith(synchronizer: Synchronizer): Boolean =
////        synchronizer.changeListSync(
////
////      )

}

