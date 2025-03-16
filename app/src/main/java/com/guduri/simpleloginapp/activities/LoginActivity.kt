package com.guduri.simpleloginapp.activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.guduri.simpleloginapp.R
import com.guduri.simpleloginapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_login)
        applyInsets()
        performOperations()


    }

    private fun performOperations(){
        onBackPressedDispatcher.addCallback(onBackPressedCallback)
        binding.btnRegister.setOnClickListener {
            var i= Intent(this,RegistrationActivity::class.java)
            startActivity(i)
        }
        binding.btnSignin.setOnClickListener {
            var i= Intent(this,ResultActivity::class.java)
            startActivity(i)

        }
        binding.btnBack.setOnClickListener {
            onBackClick()
        }
    }
    private fun applyInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.rootLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun onBackClick(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exit App")
        builder.setMessage("Are you sure you want to exit the app?")
        builder.setCancelable(false)
        builder.setPositiveButton("Yes") { dialog, id ->
            finish()
        }
        builder.setNegativeButton("No") { dialog, id ->
            dialog.dismiss()
        }
        val alertDialog = builder.create()
        alertDialog.show()
    }
    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
              onBackClick()
        }
    }
}