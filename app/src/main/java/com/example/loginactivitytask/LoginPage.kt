package com.example.loginactivitytask

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginPage : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val loginbtn = findViewById<Button>(R.id.login_btn)
        val signupbtn = findViewById<Button>(R.id.signup_btn)
        val username = findViewById<EditText>(R.id.usernamelogin_str)
        val password = findViewById<EditText>(R.id.passwordlogin_str)


        loginbtn.setOnClickListener {
            //Checking if any Field is Empty?
            if (username.text.toString().trim().isEmpty() || password.text.toString().trim()
                    .isEmpty()
            ) {
                Toast.makeText(this@LoginPage, "Fill all Details Properly!!", Toast.LENGTH_SHORT)
                    .show()

            } else {

                //Storing the Data to a Variable
                val str_username: String = username.text.toString()
                val str_password: String = password.text.toString()

                //Add Shared Preference to Store data
                Toast.makeText(
                    this@LoginPage, "Login Button Clicked on Login Page", Toast.LENGTH_SHORT
                ).show()
            }
        }

        signupbtn.setOnClickListener {
            //Redirect to SignUp Page
            Toast.makeText(
                this@LoginPage, "SignUp Button Clicked on Login Page", Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(this@LoginPage, SignUpPage::class.java)
            startActivity(intent)
        }
    }
}