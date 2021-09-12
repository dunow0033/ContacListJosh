package com.example.contactlist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.contactlist.data.db.entities.ContactItem

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ContactItem)

    @Delete
    suspend fun delete(item: ContactItem)

    @Query("SELECT * FROM contact_items")
    fun getAllContactItems(): LiveData<List<ContactItem>>
}
