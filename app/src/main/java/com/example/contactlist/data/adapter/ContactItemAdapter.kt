package com.example.contactlist.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactlist.data.db.entities.ContactItem
import com.example.contactlist.databinding.ContactItemBinding
import com.example.contactlist.ui.contactlist.ContactViewModel

class ContactItemAdapter(
    var contacts: List<ContactItem>,
    private val viewModel: ContactViewModel
) : RecyclerView.Adapter<ContactItemAdapter.ContactViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            ContactItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contacts[position]

        holder.binding.name.text = currentContact.name
        holder.binding.number.text = currentContact.number
        holder.binding.email.text = currentContact.email
        holder.binding.occupation.text = currentContact.occupation

        holder.binding.ivDelete.setOnClickListener {
            viewModel.delete(currentContact)
        }
    }

    inner class ContactViewHolder(val binding: ContactItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}