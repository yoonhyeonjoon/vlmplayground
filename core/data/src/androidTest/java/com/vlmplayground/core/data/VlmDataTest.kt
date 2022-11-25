package com.vlmplayground.core.data

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.vlmplayground.core.data.repository.OfflineFirstBulletinRepository
import com.vlmplayground.core.data.testdoubles.TestBulletinBoardDao
import com.vlmplayground.core.database.dao.BulletinBoardDao
import com.vlmplayground.core.database.model.BulletinEntity
import com.vlmplayground.core.database.model.asDataModel
import com.vlmplayground.core.network.firebase.FirebaseNetworkDataSource
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.util.*
import kotlin.test.assertTrue


class VlmDataTest {

    private lateinit var subject: OfflineFirstBulletinRepository
    private lateinit var bulletinBoardDao: BulletinBoardDao
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
    fun testSyncOfflineFirstBulletinRepository() = runTest {

        var bulletinEntity: List<BulletinEntity>?
        val bulletinBoardDao = TestBulletinBoardDao()
        val networkDataSource = FirebaseNetworkDataSource(Firebase.firestore)
        val bulletinRepository = OfflineFirstBulletinRepository(
            bulletinBoardDao = bulletinBoardDao,
            firebaseNetworkDataSource = networkDataSource
        )

        runBlocking {
            val bulletinRepositoryJob = launch {
                //Asynchronous call
                bulletinRepository.syncBulletinBoard().first()
                bulletinEntity = bulletinBoardDao.entitiesStateFlow.value

                if (bulletinEntity?.isNotEmpty() == true) {
                    assertTrue(true)
                } else {
                    assertTrue(false)
                }
            }
        }
    }


    @Test
    fun testActualInsertingToRepository() = runTest {

        var bulletinEntity: List<BulletinEntity>?
        val bulletinBoardDao = TestBulletinBoardDao()
        val networkDataSource = FirebaseNetworkDataSource(Firebase.firestore)
        val bulletinRepository = OfflineFirstBulletinRepository(
            bulletinBoardDao = bulletinBoardDao,
            firebaseNetworkDataSource = networkDataSource
        )

        runBlocking {
            val bulletinRepositoryJob = launch {
                //Asynchronous call
                bulletinRepository.uploadToBulletinBoard(
                    BulletinEntity(
                        fid = "ztxZB1Cwc55GyRrUOYrJn",
                        images = "images/001.jpg,images/002.jpg,images/003.jpg",
                        score = "111",
                        date = Date(1669066725481),
                        name = "테스트 닉네임",
                        text = "평화스러운 얼음이 천지는 되는 하여도 있는 사막이다.",
                        title = " 풍부하게 피가 뛰노는 천자만홍이 가슴이 지혜는 속잎나고, 것이다. 용감하고 작고 뿐이다. 원질이 무한한 대한 품으며,지혜는 무엇을 작고 온갖 못할 낙원을 힘차게 있는 사막이다. 것은 바이며, 두기 얼마나 우리의 우리는 튼튼하며, 불러 피다. 봄바람을 커다란 가는 쓸쓸하랴? 인간에 힘차게 그들의 쓸쓸한 예가 아름답고 없으면, 고행을 돋고, 있으랴? 하는 위하여 굳세게 철환하였는가? 하였으며, 때에, 석가는 없는 싶이 고행을 가진 불어 것이다. 심장은 피고 청춘의 피가 넣는 청춘은 밝은 쓸쓸하랴? 것은 품었기 구하지 미묘한 청춘의 그들에게 장식하는 생생하며, 뭇 것이다.	아직 헤일 이름을 이런 어머니, 사랑과 봅니다. 이름과, 나는 노루, 딴은 하나에 어머니, 당신은 토끼, 버리었습니다. 많은 위에도 불러 이름과, 있습니다.",
                    ).asDataModel()
                )
            }

            launch {
                delay(5000L)
                bulletinEntity = bulletinBoardDao.entitiesStateFlow.value
                bulletinRepositoryJob.cancel()

                if (bulletinEntity != null) {
                    assertTrue(true)
                } else {
                    assertTrue(false)
                }
            }
        }
    }
}