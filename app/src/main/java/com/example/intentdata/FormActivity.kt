package com.example.intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class FormActivity : AppCompatActivity() {

    private lateinit var imageViewPhotoForm: ImageView
    private lateinit var editTextNumber: EditText
    private lateinit var editTextPersonName: EditText
    private lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.imageViewPhotoForm = findViewById(R.id.imageViewPhotoForm)
        this.editTextPersonName = findViewById<EditText>(R.id.editTextPersonName)
        this.editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        this.buttonSave = findViewById<Button>(R.id.buttonSave)

        // create a variable that receive image from camera
        val cameraLauncher =
            registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {
                imageViewPhotoForm.setImageBitmap(it)
            }

        imageViewPhotoForm.setOnClickListener {
            cameraLauncher.launch(null)
        }

        buttonSave.setOnClickListener {
            val personName = editTextPersonName.text.toString()
            val personNumber = editTextNumber.text.toString()

            // create intent variable that olds data when activity close
            val intent = Intent().apply {
                putExtra("name", personName)
                putExtra("number", personNumber)
            }

            // close activity
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}