package com.example.contactlist.ui.contactlist

import androidx.lifecycle.ViewModel
import com.example.contactlist.data.db.entities.ContactItem
import com.example.contactlist.data.repositories.ContactRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(private val repository: ContactRepository) : ViewModel() {

    fun upsert(item: ContactItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ContactItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllContactItems() = repository.getAllContactItems()
}
