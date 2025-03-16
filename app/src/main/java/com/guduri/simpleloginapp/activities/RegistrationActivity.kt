package com.guduri.simpleloginapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.guduri.simpleloginapp.R
import com.guduri.simpleloginapp.databinding.ActivityRegistrationBinding

class RegistrationActivity:AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_registration)
        applyInsets()
        performOperations()

    }





    private fun performOperations(){
        binding.btnSubmit.setOnClickListener {
            var i=Intent(this,ResultActivity::class.java)
            startActivity(i)
            finish()
        }
    }
    private fun applyInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.rootLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}