package com.example.financemanagementclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.financemanagementclient.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.appointmentLayout.setOnClickListener{
            val intent = Intent(this@MainActivity, AppointmentActivity::class.java)
            startActivity(intent)
//            finish()
        }

        binding.expenseLayout.setOnClickListener{
            val intent = Intent(this@MainActivity, expenseActivity::class.java)
            startActivity(intent)
//            finish()
        }

        binding.incomeLayout.setOnClickListener{
            val intent = Intent(this@MainActivity, IncomeActivity::class.java)
            startActivity(intent)
//            finish()
        }

        binding.EPFLayout.setOnClickListener{
            val intent = Intent(this@MainActivity, CalculatorActivity::class.java)
            startActivity(intent)
//            finish()
        }

        binding.profileLayout.setOnClickListener{
            val intent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(intent)
//            finish()
        }

    }
}