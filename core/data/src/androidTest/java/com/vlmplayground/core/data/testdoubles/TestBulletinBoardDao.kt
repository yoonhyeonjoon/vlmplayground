package com.vlmplayground.core.data.testdoubles

import com.vlmplayground.core.database.dao.BulletinBoardDao
import com.vlmplayground.core.database.model.BulletinEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.*

class TestBulletinBoardDao : BulletinBoardDao{

    var entitiesStateFlow: MutableStateFlow<List<BulletinEntity>> = MutableStateFlow(
        listOf(
            BulletinEntity(
                fid = "o1jvdZWEqieil6M3rDwn",
                images = "images/076.jpg,images/131.jpg,images/015.jpg,images/253.jpg,images/044.jpg,images/019.jpg",
                score = "948",
                date = Date(1669021905482),
                name = "침착한 새대가리",
                text = "천하를 실로 넣는 긴지라 하는 교향악이다. 봄날의 들어 온갖 이상을 그러므로 이것은 피다.",
                title = "지혜는 뜨거운지라, 거선의 풀이 있다. 그들은 찾아 굳세게 불어 이것이야말로 쓸쓸하랴? 이상은 지혜는 보배를 거친 생명을 열락의 약동하다. 이는 무엇을 있으며, 살았으며, 예가 길을 사는가 영락과 부패뿐이다. 위하여 힘차게 대한 끓는다. 바로 있을 청춘 생생하며, 부패를 힘있다. 굳세게 품었기 대중을 풀이 아니더면, 못할 것이다. 커다란 능히 충분히 무엇을 이상, 그들의 그들은 구할 무한한 있으랴?	불러 이름과, 오면 자랑처럼 별빛이 버리었습니다. 멀리 된 것은 별 가을 위에 라이너 않은 까닭입니다."
            ),
            BulletinEntity(
                fid = "f4JvGDww2wlQFOJTMX6k",
                images = "images/003.jpg,images/039.jpg,images/195.jpg,images/222.jpg,images/191.jpg,images/025.jpg",
                score = "270",
                date = Date(1669026585477),
                name = "우월한 차이니",
                text = "위에 덮어 파란 말 피어나듯이 노새, 봅니다.",
                title = "이름을 나는 묻힌 시와 가슴속에 봄이 지나고 다하지 위에도 봅니다. 청춘이 한 별에도 아직 다하지 너무나 이름과 듯합니다. 않은 것은 별 이네들은 북간도에 계십니다. 언덕 아름다운 하나에 라이너 버리었습니다. 사랑과 별 지나고 별을 소녀들의 가득 까닭입니다.	까닭이요, 풀이 별들을 까닭입니다. 밤을 남은 너무나 묻힌 지나고 풀이 그리워 써 봅니다. 별 가을 딴은 있습니다. 내 아직 오는 봅니다."
            ),
            BulletinEntity(
                fid = "ovs9KpNsEFOaWYRJ37u5",
                images = "images/264.jpg,images/266.jpg,images/121.jpg,images/055.jpg,images/079.jpg,images/128.jpg,images/107.jpg",
                score = "877",
                date = Date(1669033185483),
                name = "외적인 곡식비단명나방",
                text = "넣는 뛰노는 찬미를 칼이다. 곧 얼마나 수 그들의 주는 이상은 인간은 원대하고, 철환하였는가?",
                title = "능히 천자만홍이 인간은 같이 평화스러운 할지라도 있는가? 오직 심장의 구하지 실로 놀이 구하지 꽃이 부패뿐이다. 꽃이 옷을 희망의 영원히 아름다우냐? 없으면 청춘 귀는 오직 찾아 따뜻한 대한 인간이 철환하였는가? 이성은 청춘에서만 끝까지 끓는다. 인생을 인간의 무엇을 거친 그들은 그들은 이것이다. 천지는 우리의 바이며, 희망의 따뜻한 쓸쓸한 못하다 황금시대다.	강아지, 아스라히 하나 별 노루, 무엇인지 이름을 별 봅니다. 별을 겨울이 파란 별 밤이 된 걱정도 듯합니다. 계집애들의 무성할 가을 별 까닭입니다.",
            ),
            BulletinEntity(
                fid = "KgRnBlbWbPfdjt61jbW5",
                images = "images/230.jpg,images/262.jpg,images/217.jpg,images/163.jpg,images/277.jpg,images/199.jpg,images/103.jpg,images/003.jpg",
                score = "357",
                date = Date(1669037205481),
                name = "불쾌한 디오시지아르",
                text = "따뜻한 수 내는 것이다.",
                title = "보내는 모래뿐일 뭇 너의 커다란 낙원을 가는 예가 운다. 안고, 이것은 이상의 뛰노는 오아이스도 얼마나 것은 철환하였는가? 가치를 고행을 눈이 열매를 있는 무엇을 과실이 얼마나 이것이다. 붙잡아 그들은 우는 지혜는 이상 미묘한 철환하였는가? 군영과 산야에 풀이 것이다. 인도하겠다는 같지 따뜻한 눈에 사막이다. 꽃 투명하되 싶이 있는 이상의 끓는 우리 착목한는 그들의 아름다우냐? 그들은 청춘의 대중을 천자만홍이 구할 것이다. 그들의 보배를 가는 약동하다.	까닭이요, 풀이 별들을 까닭입니다. 밤을 남은 너무나 묻힌 지나고 풀이 그리워 써 봅니다. 별 가을 딴은 있습니다. 내 아직 오는 봅니다."
            ),
            BulletinEntity(
                fid = "GmVVQPrc7XTDUobMiNHd",
                images = "images/093.jpg,images/203.jpg,images/057.jpg,images/269.jpg,images/251.jpg,images/174.jpg,images/169.jpg",
                score = "386",
                date = Date(1669047525482),
                name = "고운 시네마스코프",
                text = "하는 얼마나 얼음에 실현에 그들의 무엇을 뜨거운지라, 그들의 사막이다.",
                title = "구하지 없으면, 노래하며 밥을 우리 반짝이는 황금시대를 위하여서. 원질이 그러므로 위하여 것이다. 영락과 별과 없으면, 끓는 하는 온갖 가슴이 것이다. 위하여 위하여, 그들은 것이다. 만천하의 튼튼하며, 보이는 피고 열락의 이것이다. 광야에서 내는 가치를 힘있다. 작고 천자만홍이 물방아 대고, 피가 인류의 운다. 얼마나 봄바람을 평화스러운 돋고, 사막이다.	이름을 벌레는 내 언덕 나는 버리었습니다. 밤이 별 노새, 까닭입니다. 별 나는 나는 가난한 계십니다.",
            ),
            BulletinEntity(
                fid = "5F1JpDUK5gelmreDeXEx",
                images = "images/039.jpg,images/171.jpg,images/069.jpg,images/145.jpg",
                score = "64",
                date = Date(1669050465484),
                name = "모욕적인 나이테",
                text = "하는 얼마나 얼음에 실현에 그들의 무엇을 뜨거운지라, 그들의 사막이다.",
                title = "구하지 없으면, 노래하며 밥을 우리 반짝이는 황금시대를 위하여서. 원질이 그러므로 위하여 것이다. 영락과 별과 없으면, 끓는 하는 온갖 가슴이 것이다. 위하여 위하여, 그들은 것이다. 만천하의 튼튼하며, 보이는 피고 열락의 이것이다. 광야에서 내는 가치를 힘있다. 작고 천자만홍이 물방아 대고, 피가 인류의 운다. 얼마나 봄바람을 평화스러운 돋고, 사막이다.	헤일 라이너 내린 계십니다. 파란 밤을 다 별 벌써 프랑시스 우는 마리아 까닭입니다. 새워 무엇인지 위에 위에 밤을 가슴속에 지나고 계십니다. 별 보고, 별빛이 북간도에 같이 가슴속에 릴케 벌레는 어머니, 있습니다.",
            ),
            BulletinEntity(
                fid = "Z78ZWqial0r1ttPEIYGt",
                images = "images/202.jpg,images/004.jpg,images/006.jpg,images/156.jpg,images/272.jpg",
                score = "254",
                date = Date(1669054005478),
                name = "멋쩍은 나사못",
                text = "내린 이제 하나에 나는 지나고 비둘기, 까닭입니다.",
                title = "잔디가 이름과, 어머니, 못 있습니다. 벌레는 하나에 봄이 그리워 이름을 하나에 계집애들의 밤을 봅니다. 언덕 까닭이요, 언덕 거외다. 책상을 이네들은 나의 하나에 걱정도 이름을 나는 있습니다.	소녀들의 마디씩 슬퍼하는 시인의 아직 하나에 무엇인지 있습니다. 한 오면 쓸쓸함과 나의 릴케 어머님, 멀리 밤이 하나에 까닭입니다. 나의 둘 내 이름자 사람들의 계십니다.",
            ),
            BulletinEntity(
                fid = "KT1Wgzf63gWPqMtxYu1c",
                images = "images/146.jpg",
                score = "169",
                date = Date(1669059945483),
                name = "상큼한 호사불출문",
                text = "그들의 하는 실로 사라지지 관현악이며, 석가는 이상은 그것을 더운지라 것이다.",
                title = "간에 커다란 아니한 청춘에서만 고동을 사막이다. 속에 옷을 무엇이 고행을 청춘의 생명을 내는 전인 없으면 것이다. 평화스러운 생생하며, 할지니, 인간의 방황하여도, 부패를 되는 사막이다. 온갖 있는 무엇을 낙원을 사람은 돋고, 부패뿐이다. 우리 우리 인간에 넣는 그들의 주는 들어 피다. 사는가 스며들어 있음으로써 안고, 품으며, 인생에 것은 이것이야말로 약동하다. 그러므로 꽃 우는 풀밭에 우리의 굳세게 황금시대다. 얼마나 끓는 고동을 가치를 철환하였는가?	패, 그리워 벌써 옥 없이 시와 하나에 무엇인지 듯합니다. 벌써 내린 묻힌 가을 그리워 이런 이름과 거외다.",
            ),
            BulletinEntity(
                fid = "qzL1nD4EkKFOTEmlUduz",
                images = "images/011.jpg",
                score = "20",
                date = Date(1669061745484),
                name = "든든한 트리프타민",
                text = "시인의 어머니, 것은 그리고 릴케 가난한 벌써 많은 까닭입니다.",
                title = "무엇인지 어머니, 속의 내린 추억과 북간도에 가난한 같이 가을 버리었습니다. 까닭이요, 겨울이 북간도에 패, 이런 봅니다. 풀이 가난한 다 쓸쓸함과 당신은 하나에 이름자 써 버리었습니다. 헤는 무덤 벌써 오면 어머님, 이름을 이름과, 무엇인지 봅니다. 딴은 별 하나에 북간도에 사랑과 나는 멀리 버리었습니다.	이 덮어 하나에 소학교 시인의 밤을 계십니다. 밤을 까닭이요, 별 가난한 너무나 하나에 못 차 듯합니다.",
            ),
            BulletinEntity(
                fid = "ztxZBTCwcN3GyRrUOYrJn",
                images = "images/137.jpg,images/001.jpg,images/243.jpg",
                score = "351",
                date = Date(1669066725481),
                name = "얄미운 벚나무풍뎅이",
                text = "천지는 되는 평화스러운 얼음이 하여도 있는 사막이다.",
                title = "원질이 무한한 대한 품으며, 용감하고 작고 뿐이다. 풍부하게 피가 뛰노는 천자만홍이 가슴이 지혜는 속잎나고, 것이다. 지혜는 무엇을 작고 온갖 못할 낙원을 힘차게 있는 사막이다. 것은 바이며, 두기 얼마나 우리의 우리는 튼튼하며, 불러 피다. 봄바람을 커다란 가는 쓸쓸하랴? 인간에 힘차게 그들의 쓸쓸한 예가 아름답고 없으면, 고행을 돋고, 있으랴? 하는 위하여 굳세게 철환하였는가? 하였으며, 때에, 석가는 없는 싶이 고행을 가진 불어 것이다. 심장은 피고 청춘의 피가 넣는 청춘은 밝은 쓸쓸하랴? 것은 품었기 구하지 미묘한 청춘의 그들에게 장식하는 생생하며, 뭇 것이다.	아직 헤일 이름을 이런 어머니, 사랑과 봅니다. 이름과, 나는 노루, 딴은 하나에 어머니, 당신은 토끼, 버리었습니다. 많은 위에도 불러 이름과, 있습니다.",
            )
        )
    )

    override fun getAllEntityStream(): Flow<List<BulletinEntity>> = entitiesStateFlow


    override suspend fun deleteAllEntityStream() {
        throw NotImplementedError("Unused in tests")
    }

    override suspend fun insertOrIgnoreBulletins(bulletinEntities: List<BulletinEntity>): List<Long> {
        val originalValue = entitiesStateFlow.value
        originalValue.toMutableList().addAll(bulletinEntities)
        entitiesStateFlow.value = originalValue
        return originalValue.map{ 1 } //always True set
    }


    override suspend fun insertOrIgnoreBulletin(bulletinEntity: BulletinEntity): Long {
        throw NotImplementedError("Unused in tests")
    }

    override suspend fun updateBulletin(entities: List<BulletinEntity>) {
        throw NotImplementedError("Unused in tests")
    }

    //Manually upserted
    override suspend fun upsertBulletin(entities: List<BulletinEntity>) {
        val originalValue = entitiesStateFlow.value
        val beMutabled = originalValue.toMutableList()
        entities.forEach { nentity ->
            var equalityFlag = false
            for ((idx, oentity) in beMutabled.withIndex())
            {
                if(oentity.fid == nentity.fid)
                {
                    equalityFlag = true
                    beMutabled[idx] = nentity
                }

                if(equalityFlag) break
            }

            if(!equalityFlag) beMutabled.add(nentity)
        }

        entitiesStateFlow.value = originalValue
    }

    override fun getUnsyncedBulletin(): Flow<List<BulletinEntity>> {
        TODO("Not yet implemented")
    }
}