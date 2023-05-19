package com.example.contactapp.Database.Entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity(tableName = "Recent_numbers")
data class Recents(
    @PrimaryKey(autoGenerate = true) @NonNull @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String? = null,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "time") val time: String
)
