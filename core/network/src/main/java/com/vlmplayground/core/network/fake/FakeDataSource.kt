package com.vlmplayground.core.network.fake

import org.intellij.lang.annotations.Language

object FakeDataSource {

    @Language("JSON")
    val data = """
    [{
        "wid" : "22",
        "title" : "https://twitter.com/alex_vanyo",
        "text" : "Alex joined Android DevRel in 2021, and has worked supporting form factors from small watches to large foldables and tablets. His special interests include insets, Compose, testing and state.",
        "imageUrl" : "https://pbs.twimg.com/profile_images/1431339735931305989/nOE2mmi2_400x400.jpg",
        "author" : "Alex Vanyo"
    },
    {
        "wid" : "312",
        "title" : "Simona Stojanovic",
        "text" : "Android Developer Relations Engineer @Google, working on the Compose team and taking care of Layouts & Navigation.",
        "imageUrl" : "https://twitter.com/anomisSi",
        "author" : "https://pbs.twimg.com/profile_images/1437506849016778756/pG0NZALw_400x400.jpg"
    }
    ]
    """.trimIndent()

}