package com.example.authenticationsqlite_carmen

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var edtname1: EditText
    lateinit var edtname2: EditText
    lateinit var edtemail: EditText
    lateinit var edtpassword: EditText
    lateinit var btncreate: Button
    lateinit var btnlogin: Button
    lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtname1 = findViewById(R.id.edtname1)
        edtname2 = findViewById(R.id.edtname2)
        edtemail = findViewById(R.id.edtemail)
        edtpassword = findViewById(R.id.edtpassword)
        btncreate = findViewById(R.id.btncreate)
        btnlogin = findViewById(R.id.btnlogin)

        db = openOrCreateDatabase("carmenDB", Context.MODE_PRIVATE, null)

        //creating a table
        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR,jina2 VARCHAR, arafa VARCHAR,nenosiri VARCHAR)")

        btncreate.setOnClickListener {//Receive data from the user
            var name = edtname1.text.toString()
            var name2 = edtname2.text.toString()
            var email = edtemail.text.toString()
            var password = edtpassword.text.toString()
            //Check if the user is trying to submit empty records
            if (name.isEmpty() or name2.isEmpty() || email.isEmpty() or password.isEmpty()) {
                //Use the display_message() to Display a message telling the user to fill all the inputs

                //toast a message to say cannot submit empty field
                Toast.makeText(this, "CANNOT SUBMIT EMPTY FIELD", Toast.LENGTH_SHORT).show()

            } else {
                //Proceed to save your data into the db
                db.execSQL("INSERT INTO users VALUES('" + name + "','" + email + "','" + password + "','" + name2 + "')")


                //Toast a success message
                Toast.makeText(this, " USER  SAVED SUCCESSFULLY", Toast.LENGTH_SHORT).show()

            // navigating user from one activity to another
                var gotologin = Intent(this, loginActivity::class.java)
                startActivity(gotologin)
            }

        }
    }
}