package com.example.authenticationsqlite_carmen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Dashboard : AppCompatActivity(){
    lateinit var btnout:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnout = findViewById(R.id.btnout)

        btnout.setOnClickListener {
            val intent = Intent(this,loginActivity::class.java)
            startActivity(intent)

        }
    }
}