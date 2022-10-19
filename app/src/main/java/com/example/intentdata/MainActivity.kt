package com.example.intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewPersonName = findViewById<TextView>(R.id.textViewPersonName)
        val buttonEdit = findViewById<Button>(R.id.buttonEdit)


        buttonEdit.setOnClickListener {
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

                if(it.resultCode == RESULT_OK) {
                    var data = it.data
                    val name = data?.getStringExtra("name")
                    textViewPersonName.text = name
                }
            }.launch(Intent(this, FormActivity::class.java))
        }

    }
}