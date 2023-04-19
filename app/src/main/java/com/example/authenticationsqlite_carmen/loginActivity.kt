package com.example.authenticationsqlite_carmen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class loginActivity : AppCompatActivity() {

    lateinit var Email : EditText
    lateinit var Password: EditText
    lateinit var Login :Button
    lateinit var register :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Email = findViewById(R.id.etdEmail)
        Password = findViewById(R.id.edtPass)
        Login = findViewById(R.id.btnLogin)
        register = findViewById(R.id.btnreg)


        Login.setOnClickListener {



        }
        register.setOnClickListener {

           var gotomain = Intent(this,MainActivity ::class.java)
            startActivity(gotomain)


        }

    }
}