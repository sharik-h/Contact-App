package com.example.contactapp.Application

import android.app.Application
import com.example.contactapp.Database.Repository.ContactsRepository
import com.example.contactapp.Database.Repository.FavoriteRepository
import com.example.contactapp.Database.Repository.RecentsRepository
import com.example.contactapp.Database.Room.ContactRoomDatabase
import com.example.contactapp.Database.Room.FavoriteRoomDatabase
import com.example.contactapp.Database.Room.RecentRoomDatabase

class Mainapplication: Application() {
    val contactDatabase by lazy { ContactRoomDatabase.getDatabase(this) }
    val recentDatabase by lazy { RecentRoomDatabase.getDatabase(this) }
    val contactRepository by lazy { ContactsRepository(contactDatabase.contactsDao()) }
    val recentsRepository by lazy { RecentsRepository(recentDatabase.recentDao()) }
}