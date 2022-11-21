package com.vlmplayground.core.database

import android.content.Context
import androidx.room.Room
import com.vlmplayground.core.database.dao.BulletinBoardDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideVlmDatabase(@ApplicationContext context: Context) : VlmDatabase
    = Room.databaseBuilder(context, VlmDatabase::class.java, "vlm-database").build()
}