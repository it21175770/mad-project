package com.example.financemanagementclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financemanagementclient.databinding.ActivityInsertIncomeBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InsertIncomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInsertIncomeBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityInsertIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener {
            val id = binding.incomeID.text.toString()
            val type = binding.incomeType.text.toString()
            val amount = binding.incomeAmount.text.toString()
            val date = binding.incomeDate.text.toString()

            databaseReference = FirebaseDatabase.getInstance().getReference("Income Directory") //tableName
            val users = IncomeData(id,type,amount,date)
            databaseReference.child(id).setValue(users).addOnSuccessListener {
                binding.incomeID.text.clear()
                binding.incomeType.text.clear()
                binding.incomeAmount.text.clear()
                binding.incomeDate.text.clear()


                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@InsertIncomeActivity, IncomeActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener{
                Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
            }
        }

    }
}

