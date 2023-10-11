package com.cursillokotlin.firstApp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

import androidx.appcompat.widget.AppCompatEditText
import com.cursillokotlin.kotlin.R


class FirstAppActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnPulsame = findViewById<Button>(R.id.btnPulsame)

        btnPulsame.setOnClickListener(this::botonClick)
    }

    fun botonClick(v:View){

        val etName = findViewById<EditText>(R.id.etName)

        val name = etName.text.toString()

        if(name.isNotEmpty()){
            Log.i("Boton","Boton Pulsado $name")
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("EXTRA_NAME", name)
            startActivity(intent)
        }




    }
}