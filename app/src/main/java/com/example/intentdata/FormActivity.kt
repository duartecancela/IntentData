package com.example.intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val editTextPersonName = findViewById<EditText>(R.id.editTextPersonName)
        val editTextAge = findViewById<EditText>(R.id.editTextNumber)
        val buttonSave = findViewById<Button>(R.id.buttonSave)

        buttonSave.setOnClickListener {

            val personName = editTextPersonName.text.toString()
            val personNumber = editTextAge.text.toString()

            val intent = Intent()
            intent.putExtra("name", personName.toString())
            intent.putExtra("number", personNumber.toString())
            setResult(RESULT_OK, intent)
            finish()

        }

    }
}