package com.example.contactlist.ui.contactlist

import com.example.contactlist.data.db.entities.ContactItem

interface AddDialogListener {
    fun onAddButtonClicked(contact: ContactItem)
}