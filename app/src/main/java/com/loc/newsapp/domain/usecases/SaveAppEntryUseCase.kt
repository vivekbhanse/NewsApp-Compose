package com.loc.newsapp.domain.usecases

import com.loc.newsapp.domain.manager.LocalUserManager

class SaveAppEntryUseCase(private val localUserManager: LocalUserManager){
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}