package com.example.sql_assignment_sandra

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var edtName:EditText
    private lateinit var edtName2:EditText
    private lateinit var edtEmail:EditText
    private lateinit var edtPassword:EditText
    private lateinit var btnCreate:Button
    private lateinit var btnLogin:Button
    private lateinit var db:SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.edtname)
        edtName2 = findViewById(R.id.edtname2)
        edtEmail = findViewById(R.id.edtemail)
        edtPassword = findViewById(R.id.edtpassword)
        btnCreate = findViewById(R.id.btnaccount)
        btnLogin = findViewById(R.id.btnlogin)

        db = openOrCreateDatabase("SandraDB",Context.MODE_PRIVATE, null)


        db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR ,name2 VARCHAR, email VARCHAR,password VARCHAR)")

        btnCreate.setOnClickListener {

            var nam1 = edtName.toString()
            var nam2 = edtName2.toString()
            var email = edtEmail.toString()
            var passcode = edtPassword.toString()

            if (nam1.isEmpty() or nam2.isEmpty() or email.isEmpty() or passcode.isEmpty()) {

                Toast.makeText(this, "CANNOT SUBMIT", Toast.LENGTH_SHORT).show()
            }else{

                db.execSQL("INSERT INTO users VALUES('"+nam1+"','"+nam2+"','"+email+"','"+passcode+"')")

                Toast.makeText(this, "USER CREATED SUCCESSFULLY", Toast.LENGTH_SHORT).show()


                var gotologin = Intent(this, LoginActivity::class.java)
                startActivity(gotologin)
            }


        }



    }
}
