package com.example.contactapp.Database.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactapp.Database.Daos.RecentDao
import com.example.contactapp.Database.Entity.Recents

@Database(entities = [(Recents::class)], version = 4, exportSchema = false)
abstract class RecentRoomDatabase: RoomDatabase() {

    abstract fun recentDao(): RecentDao

    companion object {

        @Volatile
        private var INSTANCE: RecentRoomDatabase? = null

        fun getDatabase(context: Context): RecentRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RecentRoomDatabase::class.java,
                        "RecentContact_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}