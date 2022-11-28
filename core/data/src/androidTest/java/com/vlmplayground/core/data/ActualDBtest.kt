package com.vlmplayground.core.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.vlmplayground.core.data.repository.OfflineFirstBulletinRepository
import com.vlmplayground.core.database.VlmDatabase
import com.vlmplayground.core.database.dao.BulletinBoardDao
import com.vlmplayground.core.database.model.BulletinEntity
import com.vlmplayground.core.database.model.asDataModel
import com.vlmplayground.core.model.data.Bulletin
import com.vlmplayground.core.network.firebase.FirebaseNetworkDataSource
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.util.*

class ActualDBtest {

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

//        val bulletinBoardDao = TestBulletinBoardDao() <= replaced by Actual DB
        val networkDataSource = FirebaseNetworkDataSource(Firebase.firestore)
        val bulletinRepository = OfflineFirstBulletinRepository(
            bulletinBoardDao = bulletinBoardDao,
            firebaseNetworkDataSource = networkDataSource
        )

        val bulletinList = listOf(
            BulletinEntity(
                fid = "1111testableInsertingSet1",
                images = "images/076.jpg,images/131.jpg,images/015.jpg,images/253.jpg,images/044.jpg,images/019.jpg",
                score = "111",
                date = Date(1669021905482),
                name = "침착한 황소대가리",
                text = "천하를 실로 넣는 긴지라 하는 교향악이다. 봄날의 들어 온갖 이상을 그러므로 이것은 피다.",
                title = "지혜는 뜨거운지라, 거선의 풀이 있다. 그들은 찾아 굳세게 불어 이것이야말로 쓸쓸하랴? 이상은 지혜는 보배를 거친 생명을 열락의 약동하다. 이는 무엇을 있으며, 살았으며, 예가 길을 사는가 영락과 부패뿐이다. 위하여 힘차게 대한 끓는다. 바로 있을 청춘 생생하며, 부패를 힘있다. 굳세게 품었기 대중을 풀이 아니더면, 못할 것이다. 커다란 능히 충분히 무엇을 이상, 그들의 그들은 구할 무한한 있으랴?	불러 이름과, 오면 자랑처럼 별빛이 버리었습니다. 멀리 된 것은 별 가을 위에 라이너 않은 까닭입니다."
            ),
            BulletinEntity(
                fid = "1111testableInsertingSet2",
                images = "images/003.jpg,images/039.jpg,images/195.jpg,images/222.jpg,images/191.jpg,images/025.jpg",
                score = "222",
                date = Date(1669026585477),
                name = "우월한 차이니스",
                text = "위에 덮어 파란 말 피어나듯이 노새, 봅니다.",
                title = "이름을 나는 묻힌 시와 가슴속에 봄이 지나고 다하지 위에도 봅니다. 청춘이 한 별에도 아직 다하지 너무나 이름과 듯합니다. 않은 것은 별 이네들은 북간도에 계십니다. 언덕 아름다운 하나에 라이너 버리었습니다. 사랑과 별 지나고 별을 소녀들의 가득 까닭입니다.	까닭이요, 풀이 별들을 까닭입니다. 밤을 남은 너무나 묻힌 지나고 풀이 그리워 써 봅니다. 별 가을 딴은 있습니다. 내 아직 오는 봅니다."
            )
        )

        bulletinBoardDao.insertOrIgnoreBulletins(bulletinList)

        runBlocking {

            bulletinRepository.uploadBulletin(
                BulletinEntity(
                    fid = "1111testableInsertingSet3",
                    images = "images/001.jpg,images/002.jpg,images/003.jpg",
                    score = "111",
                    date = Date(1669066725481),
                    name = "테스트 닉네임",
                    text = "평화스러운 얼음이 천지는 되는 하여도 있는 사막이다.",
                    title = " 풍부하게 피가 뛰노는 천자만홍이 가슴이 지혜는 속잎나고, 것이다. 용감하고 작고 뿐이다. 원질이 무한한 대한 품으며,지혜는 무엇을 작고 온갖 못할 낙원을 힘차게 있는 사막이다. 것은 바이며, 두기 얼마나 우리의 우리는 튼튼하며, 불러 피다. 봄바람을 커다란 가는 쓸쓸하랴? 인간에 힘차게 그들의 쓸쓸한 예가 아름답고 없으면, 고행을 돋고, 있으랴? 하는 위하여 굳세게 철환하였는가? 하였으며, 때에, 석가는 없는 싶이 고행을 가진 불어 것이다. 심장은 피고 청춘의 피가 넣는 청춘은 밝은 쓸쓸하랴? 것은 품었기 구하지 미묘한 청춘의 그들에게 장식하는 생생하며, 뭇 것이다.	아직 헤일 이름을 이런 어머니, 사랑과 봅니다. 이름과, 나는 노루, 딴은 하나에 어머니, 당신은 토끼, 버리었습니다. 많은 위에도 불러 이름과, 있습니다.",
                ).asDataModel()
            )

        }

    }


    @Test
    fun bulletinDaoDeletingTest() = runTest {

//        val bulletinBoardDao = TestBulletinBoardDao() <= replaced by Actual DB
        val networkDataSource = FirebaseNetworkDataSource(Firebase.firestore)
        val bulletinRepository = OfflineFirstBulletinRepository(
            bulletinBoardDao = bulletinBoardDao,
            firebaseNetworkDataSource = networkDataSource
        )

        val bulletinList = listOf(
            BulletinEntity(
                fid = "1111testableInsertingSet1",
                images = "images/076.jpg,images/131.jpg,images/015.jpg,images/253.jpg,images/044.jpg,images/019.jpg",
                score = "111",
                date = Date(1669021905482),
                name = "침착한 황소대가리",
                text = "천하를 실로 넣는 긴지라 하는 교향악이다. 봄날의 들어 온갖 이상을 그러므로 이것은 피다.",
                title = "지혜는 뜨거운지라, 거선의 풀이 있다. 그들은 찾아 굳세게 불어 이것이야말로 쓸쓸하랴? 이상은 지혜는 보배를 거친 생명을 열락의 약동하다. 이는 무엇을 있으며, 살았으며, 예가 길을 사는가 영락과 부패뿐이다. 위하여 힘차게 대한 끓는다. 바로 있을 청춘 생생하며, 부패를 힘있다. 굳세게 품었기 대중을 풀이 아니더면, 못할 것이다. 커다란 능히 충분히 무엇을 이상, 그들의 그들은 구할 무한한 있으랴?	불러 이름과, 오면 자랑처럼 별빛이 버리었습니다. 멀리 된 것은 별 가을 위에 라이너 않은 까닭입니다."
            ),
            BulletinEntity(
                fid = "1111testableInsertingSet2",
                images = "images/003.jpg,images/039.jpg,images/195.jpg,images/222.jpg,images/191.jpg,images/025.jpg",
                score = "222",
                date = Date(1669026585477),
                name = "우월한 차이니스",
                text = "위에 덮어 파란 말 피어나듯이 노새, 봅니다.",
                title = "이름을 나는 묻힌 시와 가슴속에 봄이 지나고 다하지 위에도 봅니다. 청춘이 한 별에도 아직 다하지 너무나 이름과 듯합니다. 않은 것은 별 이네들은 북간도에 계십니다. 언덕 아름다운 하나에 라이너 버리었습니다. 사랑과 별 지나고 별을 소녀들의 가득 까닭입니다.	까닭이요, 풀이 별들을 까닭입니다. 밤을 남은 너무나 묻힌 지나고 풀이 그리워 써 봅니다. 별 가을 딴은 있습니다. 내 아직 오는 봅니다."
            )
        )

        bulletinList.forEach { it.requestoption = "upload" } //change state
        bulletinBoardDao.insertOrIgnoreBulletins(bulletinList)

        runBlocking {

            bulletinRepository.uploadBulletin(
                BulletinEntity(
                    fid = "1111testableInsertingSet3",
                    images = "images/001.jpg,images/002.jpg,images/003.jpg",
                    score = "111",
                    date = Date(1669066725481),
                    name = "테스트 닉네임",
                    text = "평화스러운 얼음이 천지는 되는 하여도 있는 사막이다.",
                    title = " 풍부하게 피가 뛰노는 천자만홍이 가슴이 지혜는 속잎나고, 것이다. 용감하고 작고 뿐이다. 원질이 무한한 대한 품으며,지혜는 무엇을 작고 온갖 못할 낙원을 힘차게 있는 사막이다. 것은 바이며, 두기 얼마나 우리의 우리는 튼튼하며, 불러 피다. 봄바람을 커다란 가는 쓸쓸하랴? 인간에 힘차게 그들의 쓸쓸한 예가 아름답고 없으면, 고행을 돋고, 있으랴? 하는 위하여 굳세게 철환하였는가? 하였으며, 때에, 석가는 없는 싶이 고행을 가진 불어 것이다. 심장은 피고 청춘의 피가 넣는 청춘은 밝은 쓸쓸하랴? 것은 품었기 구하지 미묘한 청춘의 그들에게 장식하는 생생하며, 뭇 것이다.	아직 헤일 이름을 이런 어머니, 사랑과 봅니다. 이름과, 나는 노루, 딴은 하나에 어머니, 당신은 토끼, 버리었습니다. 많은 위에도 불러 이름과, 있습니다.",
                ).asDataModel()
            )


            val deletingCandidate: List<Bulletin> = listOf(BulletinEntity(
            fid = "1111testableInsertingSet3",
            images = "images/001.jpg,images/002.jpg,images/003.jpg",
            score = "111",
            date = Date(1669066725481),
            name = "테스트 닉네임",
            text = "평화스러운 얼음이 천지는 되는 하여도 있는 사막이다.",
            title = " 풍부하게 피가 뛰노는 천자만홍이 가슴이 지혜는 속잎나고, 것이다. 용감하고 작고 뿐이다. 원질이 무한한 대한 품으며,지혜는 무엇을 작고 온갖 못할 낙원을 힘차게 있는 사막이다. 것은 바이며, 두기 얼마나 우리의 우리는 튼튼하며, 불러 피다. 봄바람을 커다란 가는 쓸쓸하랴? 인간에 힘차게 그들의 쓸쓸한 예가 아름답고 없으면, 고행을 돋고, 있으랴? 하는 위하여 굳세게 철환하였는가? 하였으며, 때에, 석가는 없는 싶이 고행을 가진 불어 것이다. 심장은 피고 청춘의 피가 넣는 청춘은 밝은 쓸쓸하랴? 것은 품었기 구하지 미묘한 청춘의 그들에게 장식하는 생생하며, 뭇 것이다.	아직 헤일 이름을 이런 어머니, 사랑과 봅니다. 이름과, 나는 노루, 딴은 하나에 어머니, 당신은 토끼, 버리었습니다. 많은 위에도 불러 이름과, 있습니다.",
            ).asDataModel())


            bulletinRepository.deleteBulletin(newBulletin = deletingCandidate)

        }

    }

}
