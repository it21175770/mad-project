package com.example.financemanagementclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financemanagementclient.databinding.ActivityUpdateExpenseBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateExpenseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateExpenseBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.updateButton.setOnClickListener {
            val referenceID = binding.referenceID.text.toString()
            val updateType = binding.updateType.text.toString()
            val updateAmount = binding.updateAmount.text.toString()
            val updateDate = binding.updateDate.text.toString()
            updateData(referenceID,updateType,updateAmount,updateDate)
        }
    }

    private fun updateData(id: String, type: String, amount: String, date: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Expense Directory")
        val user = mapOf<String,String>(
            "type" to type,
            "amount" to amount,
            "date" to date
        )
        databaseReference.child(id).updateChildren(user).addOnSuccessListener {
            binding.referenceID.text.clear()
            binding.updateType.text.clear()
            binding.updateAmount.text.clear()
            binding.updateDate.text.clear()
            Toast.makeText(this,"Successfully Updated", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Failed to Update", Toast.LENGTH_SHORT).show()
        }
    }
}