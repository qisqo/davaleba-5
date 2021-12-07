package com.example.davaleba5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {
    private lateinit var buttonLogout: Button
    private lateinit var buttonChangePassword: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        registerListener()
        init()
        textView.text = FirebaseAuth.getInstance().currentUser?.uid
    }

    private fun init() {
        buttonLogout = findViewById(R.id.buttonLogout)
        buttonChangePassword = findViewById(R.id.buttonChangePassword)
        textView = findViewById(R.id.textView)
    }
    private fun registerListener() {
        buttonChangePassword.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonLogout.setOnClickListener {
            startActivity(Intent(this, PasswordChangeActivity::class.java))


        }
    }

}