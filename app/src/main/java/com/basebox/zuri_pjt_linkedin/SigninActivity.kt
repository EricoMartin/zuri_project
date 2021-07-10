package com.basebox.zuri_pjt_linkedin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.basebox.zuri_pjt_linkedin.db.UserRepository
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.runBlocking

class SigninActivity : AppCompatActivity() {
   private val TAG = "SigninActivity"

    private lateinit var btn: Button
    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var signup: TextView

    private var emailUsed: String? = null
    private var passwordUsed: String? = null
    private lateinit var userRepo: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signin)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.hide()
        userRepo = UserRepository(this)

        btn = findViewById(R.id.button)
        email = findViewById(R.id.txt_email)
        password = findViewById(R.id.txt_password)
        signup = findViewById(R.id.join_text)


        btn.setOnClickListener{
            emailUsed = email.text.toString()
            passwordUsed = password.text.toString()


            val user = runBlocking {
                userRepo.getUser(emailUsed!!, passwordUsed!!)
            }

            Log.d(TAG, "Values of user $emailUsed")
            Log.d(TAG, "Values of user $passwordUsed")
            Log.d(TAG, "Values of user $user")
            if  (user?.email != emailUsed && user?.password != passwordUsed){
                Toast.makeText(this, "User Sign-up required!", Toast.LENGTH_LONG).show()
            }else {
                val intent = Intent(this, MainActivity::class.java)

                startActivity(intent)
                Toast.makeText(this, "User Sign-in Successful!", Toast.LENGTH_LONG).show()
            }
        }
        signup.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)

            startActivity(intent)
        }
    }
}