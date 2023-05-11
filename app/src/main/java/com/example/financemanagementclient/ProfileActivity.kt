package com.example.financemanagementclient

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.financemanagementclient.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.newProfile.setOnClickListener{
            val intent = Intent(this@ProfileActivity, AddProfileActivity::class.java)
            startActivity(intent)
//            finish()
        }

        binding.profileUpdate.setOnClickListener{
            val intent = Intent(this@ProfileActivity, UpdateProfileActivity::class.java)
            startActivity(intent)
        }
    }
}