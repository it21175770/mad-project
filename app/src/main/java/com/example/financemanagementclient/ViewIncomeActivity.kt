package com.example.financemanagementclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financemanagementclient.databinding.ActivityViewIncomeBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ViewIncomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewIncomeBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val searchID : String = binding.searchID.text.toString()
            if  (searchID.isNotEmpty()){
                readData(searchID)
            }else{
                Toast.makeText(this,"Please enter Income ID", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun readData(id: String){
        databaseReference = FirebaseDatabase.getInstance().getReference("Income Directory")
        databaseReference.child(id).get().addOnSuccessListener {
            if (it.exists()){
                val type = it.child("type").value
                val amount = it.child("amount").value
                val date = it.child("date").value
                Toast.makeText(this,"Results Found", Toast.LENGTH_SHORT).show()
                binding.searchID.text.clear()
                binding.readType.text = type.toString()
                binding.readAmount.text = amount.toString()
                binding.readDate.text = date.toString()
            }else{
                Toast.makeText(this,"Income ID does not exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"Something went wrong", Toast.LENGTH_SHORT).show()
        }
    }
}