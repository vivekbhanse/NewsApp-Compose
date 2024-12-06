package com.loc.newsapp.domain.usecases

import kotlinx.coroutines.flow.Flow

class AppSettingEntryUseCase(
    private val saveAppEntryUseCase: SaveAppEntryUseCase,
    private val readAppEntryUseCase: ReadAppEntryUseCase
) {
     fun getReadAppEntryUseCase(): Flow<Boolean> {
        return readAppEntryUseCase.invoke()
    }

    suspend fun setSaveAppEntryUseCase(){
        saveAppEntryUseCase.invoke()
    }
}