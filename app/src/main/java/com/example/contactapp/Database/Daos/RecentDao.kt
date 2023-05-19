package com.example.contactapp.Database.Daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contactapp.Database.Entity.Recents

@Dao
interface RecentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(recents: Recents): Long

    @Query("SELECT * FROM Recent_numbers ORDER BY time DESC")
    suspend fun getAllRecents(): List<Recents>

    @Delete
    suspend fun deleteRecent(recnet: Recents)
}