package com.example.financemanagementclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.financemanagementclient.databinding.ActivityIncomeBinding
import com.example.financemanagementclient.databinding.ActivityMainBinding

class IncomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIncomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.incomeView.setOnClickListener{
            val intent = Intent(this@IncomeActivity, ViewIncomeActivity::class.java)
            startActivity(intent)
        }

        binding.incomeInsert.setOnClickListener{
          val intent = Intent(this@IncomeActivity, InsertIncomeActivity::class.java)
           startActivity(intent)
       }

        binding.incomeUpdate.setOnClickListener{
            val intent = Intent(this@IncomeActivity, UpdateIncomeActivity::class.java)
            startActivity(intent)
        }

        binding.incomeDelete.setOnClickListener{
            val intent = Intent(this@IncomeActivity, DeleteIncomeActivity::class.java)
            startActivity(intent)
        }



    }


}