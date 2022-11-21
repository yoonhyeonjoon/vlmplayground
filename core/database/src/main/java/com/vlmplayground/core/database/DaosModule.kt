package com.vlmplayground.core.database

import com.vlmplayground.core.database.dao.BulletinBoardDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {
    @Provides
    fun provideBulletinDao(database : VlmDatabase) : BulletinBoardDao
    = database.bulletinDao()
}