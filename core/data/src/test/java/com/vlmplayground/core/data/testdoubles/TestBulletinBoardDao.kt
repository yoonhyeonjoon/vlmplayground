package com.vlmplayground.core.data.testdoubles

import com.vlmplayground.core.database.dao.BulletinBoardDao
import com.vlmplayground.core.database.model.BulletinEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class TestBulletinBoardDao : BulletinBoardDao{

    private var entitiesStateFlow: MutableStateFlow<List<BulletinEntity>> = MutableStateFlow(
        listOf(
            BulletinEntity(
                id = "22",
                title = "https://twitter.com/alex_vanyo",
                text = "Alex joined Android DevRel in 2021, and has worked supporting form factors from small watches to large foldables and tablets. His special interests include insets, Compose, testing and state.",
                imageUrl = "https://pbs.twimg.com/profile_images/1431339735931305989/nOE2mmi2_400x400.jpg",
                author = "Alex Vanyo",
            ),
            BulletinEntity(
                id = "312",
                title = "Simona Stojanovic",
                text = "Android Developer Relations Engineer @Google, working on the Compose team and taking care of Layouts & Navigation.",
                imageUrl = "https://twitter.com/anomisSi",
                author = "https://pbs.twimg.com/profile_images/1437506849016778756/pG0NZALw_400x400.jpg",
            )
        )
    )

    override fun getAllEntityStream(): Flow<List<BulletinEntity>> =
        entitiesStateFlow //.map { it }


    override suspend fun deleteAllEntityStream() {
        entitiesStateFlow.update { entities ->
            entities.take(0)
        }
    }

    override suspend fun insertOrIgnoreBulletin(bulletinEntities: List<BulletinEntity>) : List<Long> {
        entitiesStateFlow.value = bulletinEntities
        return bulletinEntities.map { it.id.toLong() }
    }

    override suspend fun updateBulletin(entities: List<BulletinEntity>) {
        throw NotImplementedError("Unused in tests")
    }

    override suspend fun upsertBulletin(entities: List<BulletinEntity>) {
        entitiesStateFlow.value = entities
    }

}