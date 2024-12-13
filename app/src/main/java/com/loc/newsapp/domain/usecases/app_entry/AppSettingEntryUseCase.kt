package com.loc.newsapp.domain.usecases.app_entry

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