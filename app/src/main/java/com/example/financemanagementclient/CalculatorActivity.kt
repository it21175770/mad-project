package com.example.financemanagementclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.financemanagementclient.databinding.ActivityCalculatorBinding
import com.example.financemanagementclient.databinding.ActivityMainBinding

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.incomeTaxLayout.setOnClickListener{
            val intent = Intent(this@CalculatorActivity, CalculateIncomeTaxActivity::class.java)
            startActivity(intent)
//            finish()
        }

        binding.EPFLayout.setOnClickListener{
            val intent = Intent(this@CalculatorActivity, CalculateETFActivity::class.java)
            startActivity(intent)
//            finish()
        }
    }
}