package com.loc.newsapp.di

import android.app.Application
import com.loc.newsapp.data.manager.LocalUserManagerImpl
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.domain.usecases.AppSettingEntryUseCase
import com.loc.newsapp.domain.usecases.ReadAppEntryUseCase
import com.loc.newsapp.domain.usecases.SaveAppEntryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(application:Application):LocalUserManager{
        return LocalUserManagerImpl(application)
    }

    @Provides
    @Singleton
    fun provideAppSettingEntryUseCase(localUserManager: LocalUserManager) = AppSettingEntryUseCase(
        readAppEntryUseCase = ReadAppEntryUseCase(localUserManager = localUserManager), saveAppEntryUseCase = SaveAppEntryUseCase(localUserManager)
    )
}