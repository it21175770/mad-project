package com.example.financemanagementclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financemanagementclient.databinding.ActivityCalculateEtfactivityBinding
import com.example.financemanagementclient.databinding.ActivityCalculateIncomeTaxBinding

class CalculateETFActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculateEtfactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculateEtfactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.EPFCalButton.setOnClickListener {
            val basicSalary = binding.basicSalaryForEPF.text.toString().toDouble()
            if  (basicSalary.isFinite()){
                readData(basicSalary)
            }else{
                Toast.makeText(this,"Please enter Basic Salary", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(basicSalary: Double){

        var epf = (basicSalary*12)/100
        var etf = (basicSalary*3)/100

        val netSalary =  basicSalary - epf + etf

        binding.readTaxEPF.text = epf.toString()
        binding.readETF.text = etf.toString()
        binding.readNetSalaryEPF.text = netSalary.toString()
    }
}