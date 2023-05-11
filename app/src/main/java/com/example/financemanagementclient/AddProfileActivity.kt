package com.example.financemanagementclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financemanagementclient.databinding.ActivityAddProfileBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddProfileBinding
    private lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener {
            val name = binding.insertName.text.toString()
            val email = binding.insertEmail.text.toString()
            val address = binding.insertAddress.text.toString()
            val phone = binding.insertPhone.text.toString()

            databaseReference = FirebaseDatabase.getInstance().getReference("Profile Directory") //tableName
            val users = ProfileData(name,email,address,phone)
            databaseReference.child(email).setValue(users).addOnSuccessListener {
                binding.insertName.text.clear()
                binding.insertEmail.text.clear()
                binding.insertAddress.text.clear()
                binding.insertPhone.text.clear()

                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@AddProfileActivity, ProfileActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener{
                Toast.makeText(this,"Failed to Save", Toast.LENGTH_SHORT).show()
            }

        }
    }
}