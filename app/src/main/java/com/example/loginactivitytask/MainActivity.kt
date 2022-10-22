package com.example.loginactivitytask

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    /*
    *  1. This is a Project Task of Login And Signup
    *  2. This Project Includes Concept of Shared preference, Tab layout, RecyclerView, API-GET Methods
    *  3. First Splash Screen Automatically Move to next Login Screen After a certain Duration0
    *  4. Login or Sign-Up Required for User. The data is Stored via Shared Preference.
    *  5. The Home Page, Document Page, Profile Page is a Tab Layout Activity.
    *  6. Home Page Fragment Contains API data through GET Method in Grid View.
    *  7. Document Page Fragment Contains same API data through GET Method in List View.
    *  8. Profile Page Fragment Contains The Signup data Through Shared Preference Method.
    *  9. Once Login, The User Stays Login.
    * 10. By Default Home Page Will be Selected Everytime
    * 11. Proper empty field validation have to be there
    * */

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