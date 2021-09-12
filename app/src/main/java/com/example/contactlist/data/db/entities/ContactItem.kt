package com.example.contactlist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_items")
data class ContactItem(
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_number")
    var number: String,
    @ColumnInfo(name = "item_email")
    var email: String,
    @ColumnInfo(name = "occupation")
    var occupation: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
