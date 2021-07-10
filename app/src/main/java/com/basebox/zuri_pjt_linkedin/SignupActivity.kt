package com.basebox.zuri_pjt_linkedin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.basebox.zuri_pjt_linkedin.databinding.ActivitySigninBinding
import com.basebox.zuri_pjt_linkedin.databinding.ActivitySignupBinding
import com.basebox.zuri_pjt_linkedin.db.UserRepository
import com.basebox.zuri_pjt_linkedin.entity.User

class SignupActivity : AppCompatActivity() {
    private val TAG = "SignupActivity"

    private var email:String?  = null
    private var password:String? = null
    private var id:Int? = 0
    private var binding: ActivitySignupBinding? = null
    private lateinit var userRepo: UserRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.hide()

            binding!!.button.setOnClickListener{
            binding?.layPass?.isVisible = true
            binding?.button?.isInvisible = true
            binding?.button3?.isVisible = true
        }

        userRepo = UserRepository(this)


        binding!!.button3.setOnClickListener {
            email = binding?.email?.editText?.text.toString()
            Log.d(TAG, "First Email: $email")
            password = binding?.layPass?.editText?.text.toString()
            if(email.isNullOrBlank() && password.isNullOrBlank()){
                Log.d(TAG, "Email: $email")
                Log.d(TAG, "Password: $password")
                Toast.makeText(this, "Email and Password Required!", Toast.LENGTH_LONG).show()
            }else{
                id = id?.plus(1)
                val user = id?.let { it1 -> User(it1, email, password) }
                if (user != null) {
                    userRepo.addUser(user)
                }
                Toast.makeText(this, "User Sign-up Successful!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, SignupActivity2::class.java)
                startActivity(intent)
            }
        }
    }
}