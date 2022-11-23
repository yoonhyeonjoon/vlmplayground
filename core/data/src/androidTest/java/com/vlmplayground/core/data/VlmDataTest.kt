package com.vlmplayground.core.data.com.vlmplayground.core.data

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.vlmplayground.core.data.repository.OfflineFirstBulletinRepository
import com.vlmplayground.core.data.testdoubles.TestBulletinBoardDao
import com.vlmplayground.core.database.dao.BulletinBoardDao
import com.vlmplayground.core.network.firebase.FirebaseNetworkDataSource
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


class VlmDataTest {

    private lateinit var subject : OfflineFirstBulletinRepository
    private lateinit var bulletinBoardDao : BulletinBoardDao
    private lateinit var networkDataSource: FirebaseNetworkDataSource

    @Before
    fun setup() {
        bulletinBoardDao = TestBulletinBoardDao()
        networkDataSource = FirebaseNetworkDataSource(Firebase.firestore)
        subject = OfflineFirstBulletinRepository(
            bulletinBoardDao = bulletinBoardDao,
            firebaseNetworkDataSource = networkDataSource
        )
    }

    @Test
    fun testOfflineFirstBulletinRepository() = runTest {

        val bulletinBoardDao = TestBulletinBoardDao()
        val networkDataSource = FirebaseNetworkDataSource(Firebase.firestore)
        val bulletinRepository = OfflineFirstBulletinRepository(
            bulletinBoardDao = bulletinBoardDao,
            firebaseNetworkDataSource = networkDataSource
        )

        runBlocking {
            val bulletinRepositoryJob = launch {
                bulletinRepository.syncBulletinBoard().collect {
                    val ff = 1
                }
            }
            launch {
                delay(5000L)
                val ff = bulletinBoardDao.entitiesStateFlow.value
                bulletinRepositoryJob.cancel()
            }
        }

//        runBlocking {
//            val dataSourceJob: Job =
//                launch {  dataSource.getBulletinByTimestamp(0).collect {
//                    getResult = it
//                 }
//                }
//            launch {
//                delay(5000L)
//                dataSourceJob.cancel()
//            }
//        }




    }
}