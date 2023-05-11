package com.example.financemanagementclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financemanagementclient.databinding.ActivityCalculateIncomeTaxBinding
import com.example.financemanagementclient.databinding.ActivityViewIncomeBinding

class CalculateIncomeTaxActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculateIncomeTaxBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculateIncomeTaxBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.incomeTaxCalButton.setOnClickListener {
            val basicSalary = binding.basicSalaryForIncomeTax.text.toString().toDouble()
            if  (basicSalary.isFinite()){
                readData(basicSalary)
            }else{
                Toast.makeText(this,"Please enter Basic Salary", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(basicSalary: Double){
        var taxRate = 0

        when {
            basicSalary <= 250000 -> {
                taxRate = 1
            }
            basicSalary <= 500000 -> {
                // Tax rate = 5%
                taxRate = 5
            }
            basicSalary <= 750000 -> {
                // Tax rate = 10%
                taxRate = 10
            }
            basicSalary <= 1000000 -> {
                // Tax rate = 15%
                taxRate = 15
            }
            basicSalary <= 1250000 -> {
                // Tax rate = 20%
                taxRate = 20
            }
            basicSalary <= 1500000 -> {
                // Tax rate = 25%
                taxRate = 25
            }
            else -> {
                // Tax rate = 30%
                taxRate = 30
            }
        }

        val taxAmount = (basicSalary * taxRate) / 100
        val netSalary =  basicSalary - taxAmount

        binding.readTaxPercentage.text = taxRate.toString()
        binding.readIncomeTaxAmount.text = taxAmount.toString()
        binding.readNetSalary.text = netSalary.toString()
    }
}