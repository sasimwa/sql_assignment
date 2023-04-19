package com.example.sql_assignment_sandra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity() {


    private lateinit var edtMail:EditText
    private lateinit var edtPasscode:EditText
    private lateinit var btnLgn:Button
    private lateinit var btnRgn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        edtMail = findViewById(R.id.edtmail)
        edtPasscode = findViewById(R.id.edtpasscode)
        btnLgn = findViewById(R.id.btnlgin)
        btnRgn = findViewById(R.id.btnrgn)


        btnLgn.setOnClickListener {  }




        btnRgn.setOnClickListener {

            var gotoregisterpage = Intent(this,MainActivity::class.java)
            startActivity(gotoregisterpage)
        }
    }
}