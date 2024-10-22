package com.example.loginactivitytask.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginactivitytask.R

/**
 *  1. This Page Provides the Basic validation for Login.
 *  2. All Login Checking has been Implemented Here.
 *  3. The proper Credentials are coming through Shared Preference.
 *  4. Sign-Up Button navigates to Sign-Up page.
 */

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val loginbtn = findViewById<Button>(R.id.login_btn)
        val signupbtn = findViewById<TextView>(R.id.signup_btn)
        val username = findViewById<EditText>(R.id.usernamelogin_str)
        val password = findViewById<EditText>(R.id.passwordlogin_str)
        var str_username: String
        var str_password: String


        loginbtn.setOnClickListener {
            //Checking if any Field is Empty?
            if (username.text.toString().trim().isEmpty() || password.text.toString().trim()
                    .isEmpty()
            ) {
                Toast.makeText(this@LoginPage, "Fill all Details Properly!!", Toast.LENGTH_SHORT)
                    .show()
            } else {

                //Storing the Data to a Variable
                str_username = username.text.toString().trim()
                str_password = password.text.toString().trim()
                val sharedPreferences: SharedPreferences = this.getSharedPreferences(
                    "sharedPref", Context.MODE_PRIVATE
                )

                val usernameKey = sharedPreferences.getString("username_key", "Default")
                val passwordKey = sharedPreferences.getString("password_key", "Default")
                if (str_username != usernameKey || str_password != passwordKey) {
                    Toast.makeText(
                        this@LoginPage, "Please enter Proper Credentials!!", Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(this@LoginPage, "Login Successful!!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@LoginPage, TabLayoutActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        signupbtn.setOnClickListener {
            //Redirect to SignUp Page
            Toast.makeText(
                this@LoginPage, "Moving to Sign-Up Page", Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(this@LoginPage, SignUpPage::class.java)
            startActivity(intent)
        }
    }
}