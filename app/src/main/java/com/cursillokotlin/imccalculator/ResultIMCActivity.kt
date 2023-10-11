package com.cursillokotlin.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.cursillokotlin.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY
import com.cursillokotlin.kotlin.R

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView

    private lateinit var btnRecalcular:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        iniComponent()
        initUI(result)
        initListener()

    }

    private fun initListener() {
        btnRecalcular.setOnClickListener{onBackPressed()}
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when(result){

            in 0.00..18.50 ->{//bajo peso
                tvResult.text = getString(R.string.title_bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_bajo))
                tvDescription.text = getString(R.string.descrption_bajo_peso)
            }
            in 18.51..24.99 ->{//normal
                tvResult.text = getString(R.string.title_normal_peso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_normal))
                tvDescription.text = getString(R.string.descrption_normal_peso)
            }
            in 25.00..29.99 ->{//sobrepeso
                tvResult.text = getString(R.string.title_sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_sobrepeso))
                tvDescription.text = getString(R.string.descrption_sobrepeso_peso)
            }

            in 30.00..99.99 ->{//obesidad
                tvResult.text = getString(R.string.title_obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_obesidad))
                tvDescription.text = getString(R.string.descrption_obesidad)
            }

            else -> { //error
                tvIMC.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_obesidad))
                tvResult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }

        }


    }

    private fun iniComponent(){
        btnRecalcular = findViewById(R.id.btnReCalculate)
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)


    }

}