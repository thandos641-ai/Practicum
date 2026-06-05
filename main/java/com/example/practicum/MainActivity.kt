package com.example.practicum

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //Declare arrays
    companion object {
        val itemArray= ArrayList<String>()
        val quantityArray= ArrayList<String>()
        val categoryArray= ArrayList<String>()
        val commentArray= ArrayList<String>()
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtlteamname = findViewById<EditText>(R.id.edtlteamname)
        val edtCategory = findViewById<EditText>(R.id.edtCategory)
        val edtQuantity = findViewById<EditText>(R.id.edtQuantity)
        val edtComment = findViewById<EditText>(R.id.edtComment)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSecond = findViewById<Button>(R.id.btnSecond)
        val btnExit = findViewById<Button>(R.id.btnExit)
        btnSecond.setOnClickListener {
            val intent = Intent(this, Screen2::class.java)
            startActivity(intent)
        }
        btnExit.setOnClickListener {
            finishAffinity()
        }
        btnAdd.setOnClickListener {
            val item = edtlteamname.text.toString()
            val quantity = edtQuantity.text.toString()
            val category = edtCategory.text.toString()
            val comment = edtComment.text.toString()
            // Error Handling
            if (item.isEmpty() || quantity.isEmpty() || category.isEmpty() || comment.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }

        }
    }
}