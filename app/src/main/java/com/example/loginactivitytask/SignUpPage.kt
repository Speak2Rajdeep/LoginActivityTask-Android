package com.example.loginactivitytask

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        val loginbtn = findViewById<Button>(R.id.login_btn)
        val signupbtn = findViewById<Button>(R.id.signup_btn)
        val username = findViewById<EditText>(R.id.username_str)
        val name = findViewById<EditText>(R.id.name_str)
        val password = findViewById<EditText>(R.id.password_str)



        signupbtn.setOnClickListener {

            //Checking if any Field is Empty?
            if (username.text.toString().trim().isEmpty() || name.text.toString().trim()
                    .isEmpty() || password.text.toString().trim().isEmpty()
            ) {
                Toast.makeText(this@SignUpPage, "Fill all Details Properly!!", Toast.LENGTH_SHORT)
                    .show()

            } else {

                //Storing the Data to a Variable
                val str_username: String = username.text.toString()
                val str_name: String = name.text.toString()
                val str_password: String = password.text.toString()

                //Add Shared Preference to Store data
                Toast.makeText(
                    this@SignUpPage,
                    "Sign-Up Button Clicked on Sign-Up Page",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }

        loginbtn.setOnClickListener {
            //Redirect to SignUp Page
            Toast.makeText(
                this@SignUpPage,
                "Login Button Clicked on Sign-Up Page",
                Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(this@SignUpPage, LoginPage::class.java)
            startActivity(intent)
        }
    }
}