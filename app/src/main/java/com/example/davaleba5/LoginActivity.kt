package com.example.davaleba5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonRegister: Button
    private lateinit var buttonForgotPassword: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        init()

        registerListeners()
    }
    private fun init() {
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonForgotPassword = findViewById(R.id.buttonForgotPassword)

    }

    private fun registerListeners() {
        buttonRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java )
            startActivity(intent)

        }
        buttonForgotPassword.setOnClickListener { val intent = Intent(this, ResetPasswordActivity::class.java )
            startActivity(intent)
        }
        buttonLogin.setOnClickListener {

            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "empty!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        gotoProfile()

                    } else {
                        Toast.makeText(this, "error!!", Toast.LENGTH_SHORT).show()
                    }
                }


        }




    }
    private fun gotoProfile() {
        val intent = Intent(this, ProfileActivity::class.java )
        startActivity(intent)
        finish()
    }



}