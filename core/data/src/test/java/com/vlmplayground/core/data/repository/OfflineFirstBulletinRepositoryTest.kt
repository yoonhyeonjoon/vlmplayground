package com.vlmplayground.core.data.repository

import com.vlmplayground.core.data.testdoubles.TestBulletinBoardDao
import com.vlmplayground.core.database.dao.BulletinBoardDao
import org.junit.Before

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

}