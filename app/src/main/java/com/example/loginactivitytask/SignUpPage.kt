package com.example.loginactivitytask

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        val loginbtn = findViewById<Button>(R.id.login_btn)
        val signupbtn = findViewById<Button>(R.id.signup_btn)

        val username = findViewById<TextView>(R.id.username_str)
        val name = findViewById<EditText>(R.id.name_str)
        val password = findViewById<EditText>(R.id.password_str)

        signupbtn.setOnClickListener {

            //Checking if any Field is Empty?
            if (name.text.toString().trim()
                    .isEmpty() || password.text.toString().trim().isEmpty()
            ) {
                Toast.makeText(this@SignUpPage, "Fill all Details Properly!!", Toast.LENGTH_SHORT)
                    .show()

            } else {
                lateinit var str_username: String
                lateinit var str_name: String
                lateinit var str_password: String

                //Storing the Data to a Variable
                str_name = name.text.toString().trim()
                str_password = password.text.toString().trim()
                username.text = "$str_name@123"
                str_username = username.text.toString().trim()


                val sharedPreferences: SharedPreferences = this.getSharedPreferences(
                    "sharedPref",
                    Context.MODE_PRIVATE
                )
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("username_key", str_username)
                editor.putString("name_key", str_name)
                editor.putString("password_key", str_password)
                editor.apply()

                Toast.makeText(
                    this@SignUpPage,
                    "Sign-Up Successful! ",
                    Toast.LENGTH_SHORT
                ).show()
                Toast.makeText(
                    this@SignUpPage,
                    "Please Note Down Your Username",
                    Toast.LENGTH_SHORT
                ).show()
                Toast.makeText(
                    this@SignUpPage,
                    "You Will be Redirecting to Login After 10 Seconds!",
                    Toast.LENGTH_LONG
                ).show()

                Handler().postDelayed({
                    val intent = Intent(this@SignUpPage, LoginPage::class.java)
                    startActivity(intent)

                }, 5000)
            }
        }


        loginbtn.setOnClickListener {
            //Redirect to SignUp Page
            Toast.makeText(
                this@SignUpPage,
                "Moving to Login page",
                Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(this@SignUpPage, LoginPage::class.java)
            startActivity(intent)
        }
    }
}