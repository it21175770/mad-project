package com.example.financemanagementclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financemanagementclient.databinding.ActivityUpdateAppointmentBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateAppointmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateAppointmentBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.updateButton.setOnClickListener {
            val referencePhone = binding.referencePhone.text.toString()
            val updateName = binding.updateName.text.toString()
            val updateOperator = binding.updateOperator.text.toString()
            val updateLocation = binding.updateLocation.text.toString()
            updateData(referencePhone,updateName,updateOperator,updateLocation)
        }
    }

    private fun updateData(phone: String, name: String, operator: String, location: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Phone Directory")
        val user = mapOf<String,String>(
            "name" to name,
            "operator" to operator,
            "location" to location
        )
        databaseReference.child(phone).updateChildren(user).addOnSuccessListener {
            binding.referencePhone.text.clear()
            binding.updateName.text.clear()
            binding.updateOperator.text.clear()
            binding.updateLocation.text.clear()
            Toast.makeText(this,"Successfully Updated", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Failed to Update", Toast.LENGTH_SHORT).show()
        }
    }

}