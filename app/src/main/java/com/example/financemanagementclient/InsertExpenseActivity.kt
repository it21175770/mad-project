package com.example.financemanagementclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financemanagementclient.databinding.ActivityInsertExpenseBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InsertExpenseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInsertExpenseBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsertExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener{
            val id = binding.insertID.text.toString()
            val type = binding.insertType.text.toString()
            val amount = binding.insertAmount.text.toString()
            val date = binding.insertDate.text.toString()

            databaseReference = FirebaseDatabase.getInstance().getReference("Expense Directory") //tableName
            val users = ExpenseData(id,type,amount,date)
            databaseReference.child(id).setValue(users).addOnSuccessListener {
                binding.insertID.text.clear()
                binding.insertType.text.clear()
                binding.insertAmount.text.clear()
                binding.insertDate.text.clear()

                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@InsertExpenseActivity, expenseActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener{
                Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
            }
        }

    }
}