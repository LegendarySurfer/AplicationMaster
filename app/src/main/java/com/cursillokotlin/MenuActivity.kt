package com.cursillokotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.cursillokotlin.firstApp.FirstAppActivity
import com.cursillokotlin.imccalculator.ImcCalculatorActivity
import com.cursillokotlin.kotlin.R
import com.cursillokotlin.superheroapp.SuperHeroListActivity
import com.cursillokotlin.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        val btnSuperHero = findViewById<Button>(R.id.btnSuperHero)


        btnSaludApp.setOnClickListener(this::navigateSaludApp)
        btnIMCApp.setOnClickListener{navigatoToImcApp()}
        btnTODO.setOnClickListener { navigateToTodoApp() }
        btnSuperHero.setOnClickListener{ navigateToSuperHeroApp()}
    }

    private fun navigateToSuperHeroApp() {
        startActivity(Intent(this,SuperHeroListActivity::class.java))
    }

    private fun navigateToTodoApp() {
        //la inicio y la creo toda en uno
        startActivity(Intent(this,TodoActivity::class.java))
    }

    private fun navigateSaludApp(v:View){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
    private fun navigatoToImcApp(){
       val intent = Intent(this,ImcCalculatorActivity::class.java)
        startActivity(intent)
    }



}