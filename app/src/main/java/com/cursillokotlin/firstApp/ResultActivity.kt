package com.cursillokotlin.firstApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.cursillokotlin.kotlin.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_result)
        val tvResult = findViewById<TextView>(R.id.tvResult)

       val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()

        tvResult.text = "Hola $name"
        Toast.makeText(this, "¿Todo bien?", Toast.LENGTH_SHORT).show()

    }
}
