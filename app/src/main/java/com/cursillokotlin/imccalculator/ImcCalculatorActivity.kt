package com.cursillokotlin.imccalculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.cursillokotlin.kotlin.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 60
    private var currentAge: Int = 30
    private var currentHeight: Int = 120

    private lateinit var viwMale: CardView
    private lateinit var viwFemale: CardView
    private lateinit var tvHeigth: TextView
    private lateinit var rsHegth: RangeSlider

    private lateinit var btnSubtractWeigth: FloatingActionButton
    private lateinit var btnPlusWeigth: FloatingActionButton
    private lateinit var tvWeight: TextView

    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate:Button

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        //inicializa los componentes
        initComponent()
        //Las funciones que estan escuchando
        initListener()
        //
        initUI()

    }

    private fun initComponent() {
        viwMale = findViewById(R.id.viewMale)
        viwFemale = findViewById(R.id.viewFemale)
        tvHeigth = findViewById(R.id.tvHeight)
        rsHegth = findViewById(R.id.rsHeight)

        btnSubtractWeigth = findViewById(R.id.btnSubtractWeigth)
        btnPlusWeigth = findViewById(R.id.btnPlusWeigth)
        tvWeight = findViewById(R.id.tvWeight)

        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)

        btnCalculate = findViewById(R.id.btnCalculate)

    }

    @SuppressLint("SuspiciousIndentation")
    private fun initListener() {
        viwMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viwFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHegth.addOnChangeListener { _, value, _ ->

            val df = DecimalFormat("#.##")
            currentHeight =  df.format(value).toInt()
            tvHeigth.text = "$currentHeight cm"
        }

        btnPlusWeigth.setOnClickListener {
            currentWeight +=  1
            setWeight()
        }
        btnSubtractWeigth.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }

        btnPlusAge.setOnClickListener {
            currentAge +=  1
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }

        btnCalculate.setOnClickListener{
          val result = calculateIMC()
            navigateToResult(result)
        }

    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
       val imc = currentWeight/(currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    //cambiar color de genero
    private fun setGenderColor() {

        viwMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viwFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {

        val ColorReference = if (isSelectedComponent) {
            R.color.background_component_selected

        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, ColorReference)

    }

    private fun initUI() {
        setGenderColor()
    }


}