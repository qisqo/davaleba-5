package com.example.davaleba5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {
    private lateinit var editTextPassword: EditText
    private lateinit var buttonChangePassword: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)
        init()
        registerListener()
    }

    private fun init() {
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonChangePassword = findViewById(R.id.buttonChangePassword)

    }
    private  fun registerListener() {
        buttonChangePassword.setOnClickListener {
            val newPassword = editTextPassword.text.toString()
            if (newPassword.isEmpty() || newPassword.length < 9) {
                Toast.makeText(this, "incorrect password!", Toast.LENGTH_SHORT).show()
            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "error!", Toast.LENGTH_SHORT).show()
                    }
                }
        }



    }



}