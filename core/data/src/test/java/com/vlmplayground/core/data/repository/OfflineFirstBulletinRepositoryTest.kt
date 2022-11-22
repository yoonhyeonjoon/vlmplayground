package com.vlmplayground.core.data.repository

import com.vlmplayground.core.data.testdoubles.TestBulletinBoardDao
import com.vlmplayground.core.database.dao.BulletinBoardDao
import com.vlmplayground.core.database.model.BulletinEntity
import com.vlmplayground.core.database.model.asDataModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class OfflineFirstBulletinRepositoryTest {

    private lateinit var subject : OfflineFirstBulletinRepository
    private lateinit var bulletinBoardDao : BulletinBoardDao

    @Before
    fun setup() {
        bulletinBoardDao = TestBulletinBoardDao()

        subject = OfflineFirstBulletinRepository(
            bulletinBoardDao = bulletinBoardDao
        )
    }

    @Test
    fun getAlldata_from_Dao_and_Check() = runTest {
        val A = bulletinBoardDao.getAllEntityStream().first().map (BulletinEntity::asDataModel)
        val B = subject.syncBulletinBoard().first()
        Assert.assertEquals(A, B)
    }

}