package com.vlmplayground.core.data.repository

import com.vlmplayground.core.data.model.asEntity
import com.vlmplayground.core.database.dao.BulletinBoardDao
import com.vlmplayground.core.database.model.BulletinEntity
import com.vlmplayground.core.database.model.asDataModel
import com.vlmplayground.core.model.data.Bulletin
import com.vlmplayground.core.network.firebase.FirebaseNetworkDataSource
import com.vlmplayground.core.network.model.asDataModel
import com.vlmplayground.core.network.model.asNetworkBulletin
import kotlinx.coroutines.flow.*
import javax.inject.Inject



class OfflineFirstBulletinRepository @Inject constructor(
    private val bulletinBoardDao: BulletinBoardDao,
    private val firebaseNetworkDataSource : FirebaseNetworkDataSource,
) : BulletinRepository {

    override fun syncBulletinBoardtoLocal(): Flow<Unit> =
        firebaseNetworkDataSource.getBulletinByTimestamp(movePoint = 432000_000)
        .map { bulletinList ->
            //newly data to Room
            bulletinBoardDao.upsertBulletin(entities = bulletinList.map{ networkBulletin ->
                networkBulletin.asDataModel().asEntity(synced = true)
            })
        }

    //upload
    override suspend fun uploadBulletin(newBulletin : Bulletin) : Boolean {
        bulletinBoardDao.insertOrIgnoreBulletin(newBulletin.asEntity(synced = false, requestoption = "upload"))
        return syncBulletinBoardtoFirebase()
    }

    //deleting
    override suspend fun deleteBulletin(newBulletin : List<Bulletin>) : Boolean {
        bulletinBoardDao.updateBulletin(newBulletin.map { it.asEntity(synced = false, requestoption = "delete") } )
        return syncBulletinBoardtoFirebase()
    }


    override suspend fun editBulletin(targetBulletin: Bulletin): Boolean {
        bulletinBoardDao.updateBulletin(listOf(targetBulletin.asEntity(synced = false, requestoption = "upload")))
        return syncBulletinBoardtoFirebase()

    }

    suspend fun syncBulletinBoardtoFirebase():Boolean {

        val getBulletinList: List<BulletinEntity> = bulletinBoardDao.getUnsyncedBulletin().first()

        //inserting
        val insertingCandidate = getBulletinList.filter { it.requestoption == "upload" }.map{it.asDataModel().asNetworkBulletin()}
        val insertingResult = if(insertingCandidate.isNotEmpty()) firebaseNetworkDataSource.insertOrIgnoreBulletins(entities = insertingCandidate) else true

        //deleting
        val deleteCandiate = getBulletinList.filter { it.requestoption == "delete" }.map{it.asDataModel().asNetworkBulletin()}
        val deletingResult = if(deleteCandiate.isNotEmpty()) firebaseNetworkDataSource.deleteBulletins(entities = deleteCandiate) else true

        return if(insertingResult && deletingResult)
        {
            getBulletinList.forEach { it.synced = true }
            bulletinBoardDao.updateBulletin(entities = getBulletinList)
            true
        }
        else
        {
            false
        }
    }
}



