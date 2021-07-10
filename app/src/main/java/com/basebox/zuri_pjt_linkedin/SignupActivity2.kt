package com.basebox.zuri_pjt_linkedin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.basebox.zuri_pjt_linkedin.entity.User

class SignupActivity2 : AppCompatActivity() {

    private lateinit var first: EditText
    private lateinit var last: EditText

    private var firstname:String?  = null
    private var lastname:String? = null


    private lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupactivity2)
        supportActionBar?.hide()

        first = findViewById(R.id.first_name)
        last = findViewById(R.id.last_name)
        btn = findViewById(R.id.button)

        btn.setOnClickListener {
            firstname = first.text.toString()
            lastname = last.text.toString()

            if(firstname.isNullOrBlank() && lastname.isNullOrBlank()){
                Toast.makeText(this, "First and Last Name is Required!", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Welcome, ${firstname}!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}