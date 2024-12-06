package com.loc.newsapp.domain.usecases

import com.loc.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUseCase(private val localUserManager: LocalUserManager) {
     operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}