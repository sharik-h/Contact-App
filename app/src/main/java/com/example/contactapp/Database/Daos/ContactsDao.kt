package com.example.contactapp.Database.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.contactapp.Database.Entity.Contacts
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactsDao {

    @Insert
    suspend fun addNewContact(contact: Contacts): Long

    @Query("SELECT * FROM myContact_table ORDER BY name ASC")
    suspend fun getAllContacts(): List<Contacts>

    @Query("SELECT * FROM myContact_table WHERE favorite = 1")
    suspend fun getAllFavorite(): List<Contacts>

    @Query("UPDATE myContact_table SET favorite = :fav WHERE id = :id")
    suspend fun updateFavorite(id: Int, fav: Int)

    @Delete
    suspend fun deleteContact(contact: Contacts)

    @Query("SELECT * FROM myContact_table WHERE id = :id")
    suspend fun getContactWithId(id: Int): Contacts

    @Query("UPDATE myContact_table SET name = :name, phone = :phone WHERE id = :id")
    suspend fun updateContact(id: Int, name: String, phone: String)
}
