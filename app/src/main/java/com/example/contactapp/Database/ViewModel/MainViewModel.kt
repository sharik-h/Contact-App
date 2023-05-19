package com.example.contactapp.Database.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.contactapp.Database.Entity.Contacts
import com.example.contactapp.Database.Entity.Recents
import com.example.contactapp.Database.Repository.ContactsRepository
import com.example.contactapp.Database.Repository.RecentsRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException


class MainViewModel(
    private val contactRepo: ContactsRepository,
    private val recentRepo: RecentsRepository,
): ViewModel() {

    val allContacts: LiveData<List<Contacts>> = contactRepo.allContacts
    val allFavorite: LiveData<List<Contacts>> = contactRepo.allFavorite
    val allRecents: LiveData<List<Recents>> = recentRepo.allRecents
    val contact: LiveData<Contacts> = contactRepo.contact

    init {
        getAllContacts()
    }

    fun getAllRecents() = viewModelScope.launch {
        recentRepo.getAllRecents()
    }

    fun getAllContacts() = viewModelScope.launch {
        contactRepo.getAllContacts()
    }

    fun addContact(contact: Contacts) = viewModelScope.launch {
        contactRepo.addContact(contact)
    }

    fun getAllFavorites() = viewModelScope.launch {
        contactRepo.getAllFavorites()
    }

    fun updateFavorite(id: Int, fav: Boolean) = viewModelScope.launch {
        contactRepo.updateFavorite(id, fav)
    }

    fun deleteContact(contact: Contacts) = viewModelScope.launch {
        contactRepo.deleteContact(contact)
    }

    fun addRecent(contact: Contacts, time: String) = viewModelScope.launch {
        val recent = Recents(name = contact.name, phone = contact.phone, time = time)
        recentRepo.addRecent(recent)
        getAllRecents()
    }

    fun getContactWithId(id: Int) = viewModelScope.launch {
        contactRepo.getContactId(id)
    }

    fun updateContact(con: Contacts) = viewModelScope.launch {
        contactRepo.updateContact(con)
    }

    fun deleteRecent(recent: Recents)= viewModelScope.launch {
        recentRepo.deleteRecent(recent)
        getAllRecents()
    }


}

class MainViewModelFactory(
    private val contactRepo: ContactsRepository,
    private val recentRepo: RecentsRepository,
    ): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_LIST")
            return MainViewModel(contactRepo, recentRepo) as T
        }
        throw IllegalArgumentException("Unknown viewModel exception")
    }
}