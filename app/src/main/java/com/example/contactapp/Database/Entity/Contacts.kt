package com.example.contactapp.Database.Entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize

@Entity(tableName = "myContact_table")
data class Contacts(
    @PrimaryKey(autoGenerate = true) @NonNull @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "name")val name: String,
    @ColumnInfo(name = "phone")val phone: String,
    @ColumnInfo(name= "favorite")val favorite: Boolean
)