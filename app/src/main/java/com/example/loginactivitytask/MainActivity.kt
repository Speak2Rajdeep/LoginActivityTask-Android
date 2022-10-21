package com.example.loginactivitytask

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var isChecked: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({
            if (isChecked) {
                isChecked = false
                val intent = Intent(this@MainActivity, LoginPage::class.java)
                startActivity(intent)
            }
        }, 2000)
    }
}