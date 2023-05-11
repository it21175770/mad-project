package com.example.financemanagementclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financemanagementclient.databinding.ActivityDeleteExpenseBinding
import com.example.financemanagementclient.databinding.ActivityDeleteIncomeBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DeleteIncomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeleteIncomeBinding
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.deleteIncomeButton.setOnClickListener {
            val id = binding.deleteIncome.text.toString()
            if (id.isNotEmpty())
                deleteData(id)
            else
                Toast.makeText(this, "Please enter correct Income ID", Toast.LENGTH_SHORT).show()
        }

    }
    private fun deleteData(id: String){
        databaseReference = FirebaseDatabase.getInstance().getReference("Income Directory")
        databaseReference.child(id).removeValue().addOnSuccessListener {
            binding.deleteIncome.text.clear()
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Unable to delete", Toast.LENGTH_SHORT).show()
        }
    }
}