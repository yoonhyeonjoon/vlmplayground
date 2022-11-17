package com.vlmplayground.core.data.repository

import com.vlmplayground.core.database.dao.BulletinBoardDao
import com.vlmplayground.core.database.model.BulletinEntity
import com.vlmplayground.core.database.model.asExternalModel
import com.vlmplayground.core.model.data.Bulletin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstBulletinRepository @Inject constructor(
    private val bulletinBoardDao: BulletinBoardDao,
//    private val network: NetworkDataSource,
) : BulletinRepository {


    override fun getBulletinStream(): Flow<List<Bulletin>> =
        bulletinBoardDao.getAllEntityStream().map { it.map(BulletinEntity::asExternalModel) }

//    override suspend fun syncWith(synchronizer: Synchronizer): Boolean =
//        synchronizer.changeListSync(
//
//      )
}

