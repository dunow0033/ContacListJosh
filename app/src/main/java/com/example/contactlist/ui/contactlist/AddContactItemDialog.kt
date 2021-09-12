package com.example.contactlist.ui.contactlist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.contactlist.R
import com.example.contactlist.data.db.entities.ContactItem
import com.example.contactlist.databinding.ActivityContactBinding
import com.example.contactlist.databinding.DialogAddContactItemBinding

class AddContactItemDialog(context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {

//    Not using this because of null exception
//    private var _binding: DialogAddContactItemBinding? = null
//    private val binding: DialogAddContactItemBinding get() = _binding!!

    private lateinit var binding: DialogAddContactItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddContactItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            tvAdd.setOnClickListener {
                val name = etName.text.toString()
                val number = etNumber.text.toString()
                val email = etEmail.text.toString()
                val occupation = etOccupation.text.toString()

                if (name.isEmpty() || number.isEmpty() || email.isEmpty() || occupation.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Please enter all the information required",
                        Toast.LENGTH_SHORT
                    ).show()

                    return@setOnClickListener
                }

                val contact = ContactItem(name, number, email, occupation)
                addDialogListener.onAddButtonClicked(contact)
                dismiss()
            }

            tvCancel.setOnClickListener {
                cancel()
            }
        }
    }
}