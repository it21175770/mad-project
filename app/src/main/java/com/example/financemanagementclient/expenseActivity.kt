package com.example.financemanagementclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.financemanagementclient.databinding.ActivityAppointmentBinding
import com.example.financemanagementclient.databinding.ActivityExpenseBinding

class expenseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpenseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.expenseInsert.setOnClickListener{
            val intent = Intent(this@expenseActivity, InsertExpenseActivity::class.java)
            startActivity(intent)
//            finish()
        }

        binding.expenseView.setOnClickListener{
            val intent = Intent(this@expenseActivity, ViewExpenseActivity::class.java)
            startActivity(intent)
        }

        binding.expenseUpdate.setOnClickListener{
            val intent = Intent(this@expenseActivity, UpdateExpenseActivity::class.java)
            startActivity(intent)
        }

        binding.expenseDelete.setOnClickListener(View.OnClickListener{
            val intent = Intent(this@expenseActivity, DeleteExpenseActivity::class.java)
            startActivity(intent)
        })

    }

}