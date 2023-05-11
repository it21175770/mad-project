package com.example.financemanagementclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.financemanagementclient.databinding.ActivityAppointmentBinding

class AppointmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppointmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainUpload.setOnClickListener{
            val intent = Intent(this@AppointmentActivity, UploadAppointmentActivity::class.java)
            startActivity(intent)
//            finish()
        }

        binding.mainView.setOnClickListener{
            val intent = Intent(this@AppointmentActivity, ViewAppointmentActivity::class.java)
            startActivity(intent)
        }

        binding.mainUpdate.setOnClickListener{
            val intent = Intent(this@AppointmentActivity, UpdateAppointmentActivity::class.java)
            startActivity(intent)
        }

        binding.mainDelete.setOnClickListener(View.OnClickListener{
            val intent = Intent(this@AppointmentActivity, DeleteAppointmentActivity::class.java)
            startActivity(intent)
        })

    }
}