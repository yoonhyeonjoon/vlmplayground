/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vlmplayground.core.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.vlmplayground.core.database.VlmDatabase
import com.vlmplayground.core.database.model.BulletinEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.util.*

class BulletinBoardDaoTest {

    private lateinit var bulletinBoardDao: BulletinBoardDao
    private lateinit var db: VlmDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            VlmDatabase::class.java
        ).build()
        bulletinBoardDao = db.bulletinDao()
    }

    @Test
    fun bulletinDaoInsertingTest() = runTest {

        val bulletinList = listOf(
            BulletinEntity(
                fid = "testableInsertingSet1",
                images = "images/076.jpg,images/131.jpg,images/015.jpg,images/253.jpg,images/044.jpg,images/019.jpg",
                score = "111",
                date = Date(1669021905482),
                name = "침착한 황소대가리",
                text = "천하를 실로 넣는 긴지라 하는 교향악이다. 봄날의 들어 온갖 이상을 그러므로 이것은 피다.",
                title = "지혜는 뜨거운지라, 거선의 풀이 있다. 그들은 찾아 굳세게 불어 이것이야말로 쓸쓸하랴? 이상은 지혜는 보배를 거친 생명을 열락의 약동하다. 이는 무엇을 있으며, 살았으며, 예가 길을 사는가 영락과 부패뿐이다. 위하여 힘차게 대한 끓는다. 바로 있을 청춘 생생하며, 부패를 힘있다. 굳세게 품었기 대중을 풀이 아니더면, 못할 것이다. 커다란 능히 충분히 무엇을 이상, 그들의 그들은 구할 무한한 있으랴?	불러 이름과, 오면 자랑처럼 별빛이 버리었습니다. 멀리 된 것은 별 가을 위에 라이너 않은 까닭입니다."
            ),
            BulletinEntity(
                fid = "testableInsertingSet2",
                images = "images/003.jpg,images/039.jpg,images/195.jpg,images/222.jpg,images/191.jpg,images/025.jpg",
                score = "222",
                date = Date(1669026585477),
                name = "우월한 차이니스",
                text = "위에 덮어 파란 말 피어나듯이 노새, 봅니다.",
                title = "이름을 나는 묻힌 시와 가슴속에 봄이 지나고 다하지 위에도 봅니다. 청춘이 한 별에도 아직 다하지 너무나 이름과 듯합니다. 않은 것은 별 이네들은 북간도에 계십니다. 언덕 아름다운 하나에 라이너 버리었습니다. 사랑과 별 지나고 별을 소녀들의 가득 까닭입니다.	까닭이요, 풀이 별들을 까닭입니다. 밤을 남은 너무나 묻힌 지나고 풀이 그리워 써 봅니다. 별 가을 딴은 있습니다. 내 아직 오는 봅니다."
            )
        )

        bulletinBoardDao.insertOrIgnoreBulletins(
            bulletinList
        )

        bulletinBoardDao.insertOrIgnoreBulletin(BulletinEntity(
            fid = "testableInsertingSet3",
            images = "images/003.jpg,images/039.jpg,images/195.jpg,images/222.jpg,images/191.jpg,images/025.jpg",
            score = "270",
            date = Date(1669026585477),
            name = "우월한 차이니",
            text = "위에 덮어 파란 말 피어나듯이 노새, 봅니다.",
            title = "이름을 나는 묻힌 시와 가슴속에 봄이 지나고 다하지 위에도 봅니다. 청춘이 한 별에도 아직 다하지 너무나 이름과 듯합니다. 않은 것은 별 이네들은 북간도에 계십니다. 언덕 아름다운 하나에 라이너 버리었습니다. 사랑과 별 지나고 별을 소녀들의 가득 까닭입니다.	까닭이요, 풀이 별들을 까닭입니다. 밤을 남은 너무나 묻힌 지나고 풀이 그리워 써 봅니다. 별 가을 딴은 있습니다. 내 아직 오는 봅니다."
        ))

        bulletinBoardDao.insertOrIgnoreBulletin(BulletinEntity(
            fid = "testableInsertingSet4",
            images = "images/003.jpg,images/039.jpg,images/195.jpg,images/222.jpg,images/191.jpg,images/025.jpg",
            score = "270",
            date = Date(1669026585477),
            name = "우월한 차이니",
            text = "위에 덮어 파란 말 피어나듯이 노새, 봅니다.",
            title = "이름을 나는 묻힌 시와 가슴속에 봄이 지나고 다하지 위에도 봅니다. 청춘이 한 별에도 아직 다하지 너무나 이름과 듯합니다. 않은 것은 별 이네들은 북간도에 계십니다. 언덕 아름다운 하나에 라이너 버리었습니다. 사랑과 별 지나고 별을 소녀들의 가득 까닭입니다.	까닭이요, 풀이 별들을 까닭입니다. 밤을 남은 너무나 묻힌 지나고 풀이 그리워 써 봅니다. 별 가을 딴은 있습니다. 내 아직 오는 봅니다."
        ))

        val getEntry = bulletinBoardDao.getAllEntityStream().first()


//        assertEquals(
//            listOf(3L, 2L, 1L, 0L),
//            savedNewsResourceEntities.map {
//                it.asExternalModel().publishDate.toEpochMilliseconds()
//            }
//        )

    }


}
