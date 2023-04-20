package com.example.authenticationsqlite_carmen

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class loginActivity : AppCompatActivity() {

    lateinit var Email : EditText
    lateinit var Password: EditText
    lateinit var Login :Button
    lateinit var register :Button
    lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Email = findViewById(R.id.etdEmail)
        Password = findViewById(R.id.edtPass)
        Login = findViewById(R.id.btnLogin)
        register = findViewById(R.id.btnreg)

        db = openOrCreateDatabase("carmenDB", Context.MODE_PRIVATE, null)
        

        Login.setOnClickListener {
            var email = Email.text.toString().trim()
            var passlgn = Password.text.toString().trim()

            if (email.isEmpty() || passlgn.isEmpty()) {

                Toast.makeText(this, "CANNOT SUBMIT EMPTY TEXT", Toast.LENGTH_SHORT).show()
            } else {
                val cursor = db.rawQuery(
                    "SELECT * FROM users WHERE arafa=? AND nenosiri=?",
                    arrayOf(email, passlgn)
                )

                if (cursor != null && cursor.moveToFirst()) {
                    // user is authenticated, start a new activity
                    val intent = Intent(this, Dashboard::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        this,
                        "Invalid email or password, please try again",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }




            register.setOnClickListener {

                var gotomain = Intent(this, MainActivity::class.java)
                startActivity(gotomain)


            }

        }
    }
}