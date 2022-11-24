package com.vlmplayground.core.database.dao

import androidx.room.*
import com.vlmplayground.core.database.model.BulletinEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface BulletinBoardDao {

    @Query(
        value = """
        SELECT * FROM bulletinboard
        """
    )
    fun getAllEntityStream(): Flow<List<BulletinEntity>>

    @Query(
        value = """
            DELETE FROM bulletinboard
        """
    )
    suspend fun deleteAllEntityStream()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreBulletin(bulletinEntity : BulletinEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreBulletins(bulletinEntities: List<BulletinEntity>): List<Long>

    @Update
    suspend fun updateBulletin(entities: List<BulletinEntity>)

    @Upsert
    suspend fun upsertBulletin(entities: List<BulletinEntity>)

}