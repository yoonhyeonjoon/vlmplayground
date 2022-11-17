package com.vlmplayground.core.data.di

import com.vlmplayground.core.data.repository.BulletinRepository
import com.vlmplayground.core.data.repository.OfflineFirstBulletinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsBulletinRepository(
        topicsRepository: OfflineFirstBulletinRepository
    ): BulletinRepository
}


