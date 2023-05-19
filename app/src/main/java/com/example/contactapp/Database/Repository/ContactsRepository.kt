package com.example.contactapp.Database.Repository

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.example.contactapp.Database.Daos.ContactsDao
import com.example.contactapp.Database.Entity.Contacts
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.forEach
class ContactsRepository(private val contactDao: ContactsDao) {

    val allContacts =  MutableLiveData<List<Contacts>>()
    val allFavorite = MutableLiveData<List<Contacts>>()
    val contact = MutableLiveData<Contacts>()


    suspend fun getAllContacts() {
       allContacts.postValue(contactDao.getAllContacts())
    }

    @Suppress
    @WorkerThread
    suspend fun addContact(contact: Contacts){
        contactDao.addNewContact(contact)
    }

    suspend fun getAllFavorites() {
        allFavorite.postValue(contactDao.getAllFavorite())
    }

    suspend fun updateFavorite(id: Int, fav: Boolean) {
        contactDao.updateFavorite(id, if (fav) 1 else 0)
    }

    suspend fun deleteContact(contact: Contacts) {
        contactDao.deleteContact(contact)
    }

    suspend fun getContactId(id: Int) {
        contact.postValue(contactDao.getContactWithId(id))
    }

    suspend fun updateContact(con: Contacts) {
        contactDao.updateContact(id = con.id, name = con.name, phone = con.phone)
    }


}

