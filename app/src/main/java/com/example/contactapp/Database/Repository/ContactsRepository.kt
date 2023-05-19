package com.example.contactapp.Database.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.contactapp.Database.Daos.ContactsDao
import com.example.contactapp.Database.Entity.Contacts

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

    suspend fun searchContact(nameOrNumber: String) {
       allContacts.postValue(contactDao.searchContact(nameOrNumber,))
    }

}

