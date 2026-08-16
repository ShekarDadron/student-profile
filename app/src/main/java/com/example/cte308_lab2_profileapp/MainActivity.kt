package com.example.cte308_lab2_profileapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab2.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mainScrollView = findViewById<android.view.View>(R.id.mainScrollView)
        ViewCompat.setOnApplyWindowInsetsListener(mainScrollView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize UI elements
        val etFullName = findViewById<TextInputEditText>(R.id.etFullName)
        val etStudentId = findViewById<TextInputEditText>(R.id.etStudentId)
        val etProgramme = findViewById<TextInputEditText>(R.id.etProgramme)
        val etDepartment = findViewById<TextInputEditText>(R.id.etDepartment)
        val etSemester = findViewById<TextInputEditText>(R.id.etSemester)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPhone = findViewById<TextInputEditText>(R.id.etPhone)

        val btnSave = findViewById<MaterialButton>(R.id.btnSave)
        val btnClear = findViewById<MaterialButton>(R.id.btnClear)
        val btnEdit = findViewById<MaterialButton>(R.id.btnEdit)

        // Save Button Logic
        btnSave.setOnClickListener {
            val name = etFullName.text.toString()
            if (name.isNotEmpty()) {
                Toast.makeText(this, "Profile Saved: $name", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
        }

        // Clear Button Logic
        btnClear.setOnClickListener {
            etFullName.text?.clear()
            etStudentId.text?.clear()
            etProgramme.text?.clear()
            etDepartment.text?.clear()
            etSemester.text?.clear()
            etEmail.text?.clear()
            etPhone.text?.clear()
            Toast.makeText(this, "Fields Cleared", Toast.LENGTH_SHORT).show()
        }

        // Edit Button Logic
        btnEdit.setOnClickListener {
            Toast.makeText(this, "Edit Mode Enabled", Toast.LENGTH_SHORT).show()
        }
    }
}