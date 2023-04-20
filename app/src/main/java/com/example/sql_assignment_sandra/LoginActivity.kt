package com.example.sql_assignment_sandra

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity() {


    private lateinit var edtMail:EditText
    private lateinit var edtPasscode:EditText
    private lateinit var btnLgn:Button
    private lateinit var btnRgn:Button
    private lateinit var db:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        edtMail = findViewById(R.id.edtmail)
        edtPasscode = findViewById(R.id.edtpasscode)
        btnLgn = findViewById(R.id.btnlgin)
        btnRgn = findViewById(R.id.btnrgn)

        db = openOrCreateDatabase("SandraDB",Context.MODE_PRIVATE, null)


        btnLgn.setOnClickListener {


            var mailog = edtMail.text.toString().trim()
            var password = edtPasscode.text.toString().trim()


            if (mailog.isEmpty() || password.isEmpty()){

                Toast.makeText(this, "Cannot Submit Empty Fields", Toast.LENGTH_SHORT).show()
            }

             else{
                val cursor = db.rawQuery("SELECT * FROM sandra WHERE email=? AND password=?", arrayOf(mailog, password))

                if (cursor != null && cursor.moveToFirst()) {
                    // user is authenticated, start a new activity
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid email or password, please try again", Toast.LENGTH_SHORT).show()
                }
            }


                    }





        btnRgn.setOnClickListener {

            var gotoregisterpage = Intent(this,MainActivity::class.java)
            startActivity(gotoregisterpage)
        }
    }
}