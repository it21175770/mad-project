package com.example.financemanagementclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financemanagementclient.databinding.ActivityUpdateIncomeBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateIncomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateIncomeBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.updateIncomeButton.setOnClickListener {
            val referenceID = binding.referenceIncomeID.text.toString()
            val updateType = binding.updateIncomeType.text.toString()
            val updateAmount = binding.updateIncomeAmount.text.toString()
            val updateDate = binding.updateIncomeDate.text.toString()
            updateData(referenceID,updateType,updateAmount,updateDate)
        }

    }
    private fun updateData(id: String, type: String, amount: String, date: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Income Directory")
        val user = mapOf<String,String>(
            "type" to type,
            "amount" to amount,
            "date" to date
        )
        databaseReference.child(id).updateChildren(user).addOnSuccessListener {
            binding.referenceIncomeID.text.clear()
            binding.updateIncomeType.text.clear()
            binding.updateIncomeAmount.text.clear()
            binding.updateIncomeDate.text.clear()
            Toast.makeText(this,"Successfully Updated", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Failed to Update", Toast.LENGTH_SHORT).show()
        }
    }
}