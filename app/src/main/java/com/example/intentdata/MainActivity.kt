package com.example.intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonEdit = findViewById<Button>(R.id.buttonEdit)

        buttonEdit.setOnClickListener {
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {


            }.launch(Intent(this, FormActivity::class.java))
        }

    }
}