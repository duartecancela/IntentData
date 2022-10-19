package com.example.intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var textViewPersonName: TextView
    private lateinit var textViewNumber: TextView
    private lateinit var buttonEdit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.textViewPersonName = findViewById<TextView>(R.id.textViewPersonName)
        this.textViewNumber = findViewById<TextView>(R.id.textViewNumber)
        this.buttonEdit = findViewById<Button>(R.id.buttonEdit)

        // create a variable that receive data from other activity
        val launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == RESULT_OK) {
                val data = result.data!!
                val name = data.getStringExtra("name")
                val nr = data.getStringExtra("number")

                textViewPersonName.text = name
                textViewNumber.text = nr
            }
        }

        // call FormActivity
        buttonEdit.setOnClickListener {
            val i = Intent(this, FormActivity::class.java)
            launcher.launch(i)
        }
    }
}