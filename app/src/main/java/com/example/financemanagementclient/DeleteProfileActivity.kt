package com.example.financemanagementclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financemanagementclient.databinding.ActivityDeleteIncomeBinding
import com.example.financemanagementclient.databinding.ActivityDeleteProfileBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DeleteProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeleteProfileBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.deleteProfileButton.setOnClickListener {
            val id = binding.deleteProfile.text.toString()
            if (id.isNotEmpty())
                deleteData(id)
            else
                Toast.makeText(this, "Please enter correct Income ID", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteData(id: String){
        databaseReference = FirebaseDatabase.getInstance().getReference("Profile Directory")
        databaseReference.child(id).removeValue().addOnSuccessListener {
            binding.deleteProfile.text.clear()
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Unable to delete", Toast.LENGTH_SHORT).show()
        }
    }
}