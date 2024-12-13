package com.loc.newsapp.presentation.onboarding

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.loc.newsapp.domain.usecases.app_entry.AppSettingEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appSettingEntryUseCase: AppSettingEntryUseCase,
    private val firestore: FirebaseFirestore
) : ViewModel() {

    init {
        //saveFireBaseValue()
        readValueFireStore()
    }

    fun onEvent(event: OnBoardingEvent) {
        when (event) {
            is OnBoardingEvent.SaveAppEntry -> {
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appSettingEntryUseCase.setSaveAppEntryUseCase()
        }
    }

    fun saveFireBaseValue(){
        val map = mutableMapOf<String, String>()
        map.put("TITLE", "TITLE")
        map.put("DESC", "DESC")
        firestore.collection("collection").
        document("document").set(map)
            .addOnSuccessListener {
//                Toast.makeText(this,"Success", Toast.LENGTH_SHORT).show()
                Log.d("firestore ","Success")
            }
            .addOnFailureListener {
//                Toast.makeText(this,"Failed".plus(it.toString()), Toast.LENGTH_SHORT).show()
                Log.d("firestore ", it.toString())
            }
    }

    fun readValueFireStore(){
        firestore.collection("collection").
        document("document").get().addOnSuccessListener{
            Log.d("firestore ","Success On Get")
            Log.d("firestore ","${it.get("DESC")}")
        }.addOnFailureListener {
            Log.d("firestore ", "Fail on Get"+it.toString())

        }
    }


}