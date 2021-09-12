package com.example.contactlist.data.repositories

import com.example.contactlist.data.db.ContactDatabase
import com.example.contactlist.data.db.entities.ContactItem

class ContactRepository(
    private val db: ContactDatabase
) {
    suspend fun upsert(item: ContactItem) = db.getContactDao().upsert(item)

    suspend fun delete(item: ContactItem) = db.getContactDao().delete(item)

    fun getAllContactItems() = db.getContactDao().getAllContactItems()
}