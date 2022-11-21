package com.vlmplayground.core.model.data

import java.util.*

data class Bulletin(
    var fid: String,
    var images: List<String>,
    var date: Date ,
    var score: Long,
    var name: String,
    var text: String,
    var title: String
)

val previewBulletins = listOf(
    Bulletin(
        fid = "1vUwh0CY4mwecal2n8BR",
        images = listOf<String>("images/125.jpg", "images/120.jpg", "images/38.jpg"),
        date = Date(),
        score = 781,
        name = "모자란 팀파눔",
        text = "부패를 트고, 꾸며 보는 군영과 쓸쓸하랴? 없는 때에, 청춘의 청춘의 우리의 소담스러운 것이다. 바이며, 인생의 생의 약동하다. 품었기 이 심장은 철환하였는가? 가는 바이며, 이상이 온갖 우리의 힘차게 우리 굳세게 새 이것이다. 보는 쓸쓸한 못할 동산에는 이것이다. 속에 투명하되 그들은 있을 낙원을 기관과 곳이 있으랴? 같이 위하여 새가 그들에게 설산에서 청춘을 그리하였는가? 온갖 관현악이며, 얼마나 이상 위하여 동산에는 봄바람이다. 수 우리 투명하되 스며들어 과실이 소담스러운 것이다. 발휘하기 방지하는 석가는 하여도 그것은 이상, 이것이야말로 넣는 피다.",
        title = "이웃 쓸쓸함과 겨울이 나는 소녀들의 슬퍼하는 하나에 이름과, 아침이 계십니다. 책상을 남은 이름을 말 이국 봅니다."
    ),
    Bulletin(
        fid = "KT1Wgzf63gWPqMtxYu1c",
        images = listOf<String>("images/25.jpg", "images/17.jpg", "images/31.jpg"),
        date = Date(),
        score = 71,
        name = "상큼한 호사불출문",
        text = "그들의 하는 실로 사라지지 관현악이며, 석가는 이상은 그것을 더운지라 것이다. 간에 커다란 아니한 청춘에서만 고동을 사막이다. 속에 옷을 무엇이 고행을 청춘의 생명을 내는 전인 없으면 것이다. 평화스러운 생생하며, 할지니, 인간의 방황하여도, 부패를 되는 사막이다. 온갖 있는 무엇을 낙원을 사람은 돋고, 부패뿐이다. 우리 우리 인간에 넣는 그들의 주는 들어 피다. 사는가 스며들어 있음으로써 안고, 품으며, 인생에 것은 이것이야말로 약동하다. 그러므로 꽃 우는 풀밭에 우리의 굳세게 황금시대다. 얼마나 끓는 고동을 가치를 철환하였는가?",
        title = "패, 그리워 벌써 옥 없이 시와 하나에 무엇인지 듯합니다. 벌써 내린 묻힌 가을 그리워 이런 이름과 거외다."
    )
)

