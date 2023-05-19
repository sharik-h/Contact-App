package com.example.contactapp.Database.Repository

import androidx.lifecycle.MutableLiveData
import com.example.contactapp.Database.Daos.RecentDao
import com.example.contactapp.Database.Entity.Recents

class RecentsRepository(private val recentDao: RecentDao) {

    val allRecents = MutableLiveData<List<Recents>>()

    suspend fun getAllRecents() {
        allRecents.postValue(recentDao.getAllRecents())
    }

    suspend fun addRecent(recents: Recents){
       println( recentDao.insert(recents))
    }

    suspend fun deleteRecent(recent: Recents) {
        recentDao.deleteRecent(recent)
    }
}
