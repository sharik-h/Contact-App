package com.example.contactapp.Database.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactapp.Database.Daos.ContactsDao
import com.example.contactapp.Database.Entity.Contacts

@Database(entities = [(Contacts::class)], version = 2, exportSchema = false)
abstract class ContactRoomDatabase: RoomDatabase() {

    abstract fun contactsDao(): ContactsDao

    companion object {

        @Volatile
        private var INSTANCE :ContactRoomDatabase? = null

        fun getDatabase(context: Context): ContactRoomDatabase {
             synchronized(this) {
                var instance = INSTANCE
                 if (instance == null) {
                     instance = Room.databaseBuilder(
                         context.applicationContext,
                         ContactRoomDatabase::class.java,
                         "myContact_database"
                     ).fallbackToDestructiveMigration()
                         .build()

                     INSTANCE = instance
                 }

               return instance
            }
        }
    }
}