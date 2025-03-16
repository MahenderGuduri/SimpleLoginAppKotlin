package com.guduri.simpleloginapp.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.guduri.simpleloginapp.R
import com.guduri.simpleloginapp.databinding.ActivitySpashScreenBinding


class SpashScreenActivity : AppCompatActivity() {
    lateinit var handler: Handler
    lateinit var binding: ActivitySpashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_spash_screen)
        applyInsets()
        performOperations()


    }


    private fun performOperations() {
        onBackPressedDispatcher.addCallback(onBackPressedCallback)
        handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            var i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {

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