package com.example.financemanagementclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financemanagementclient.databinding.ActivityUpdateProfileBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateProfileBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.updateButton.setOnClickListener {
            val name = binding.name.text.toString()
            val email = binding.emailAddress.text.toString()
            val address = binding.Address.text.toString()
            val phone = binding.phone.text.toString()
            updateData(name,email,address,phone)
        }
    }

    private fun updateData(name: String, email: String, address: String, phone: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Profile Directory")
        val user = mapOf(
            "name" to name,
            "address" to address,
            "phone" to phone
        )
        databaseReference.child(email).updateChildren(user).addOnSuccessListener {
            binding.name.text.clear()
            binding.emailAddress.text.clear()
            binding.Address.text.clear()
            binding.phone.text.clear()
            Toast.makeText(this,"Successfully Updated", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Failed to Update", Toast.LENGTH_SHORT).show()
        }
    }
}