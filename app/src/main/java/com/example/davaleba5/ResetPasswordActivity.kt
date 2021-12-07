package com.example.davaleba5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordActivity : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSendEmail: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        init()
        registerListeners()


    }
    private fun init() {
        editTextEmail = findViewById(R.id.editTextEmail)
        buttonSendEmail = findViewById(R.id.buttonSendEmail)
    }

    private fun registerListeners() {
        buttonSendEmail.setOnClickListener {
            val email = editTextEmail.text.toString()
            if (email.isEmpty()) {
                Toast.makeText(this, "email is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "check your email", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }



}