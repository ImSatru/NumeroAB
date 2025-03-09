package com.example.numeroab

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.numeroab.databinding.ActivityMainBinding
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //viewbinding

        val enlace = ActivityMainBinding.inflate(layoutInflater)
        setContentView(enlace.root)


        enlace.radioGroup1.setOnCheckedChangeListener { _, checkedId -> realizarOperacion(enlace, checkedId) }
        enlace.radioGroup2.setOnCheckedChangeListener { _, checkedId -> realizarOperacion(enlace, checkedId) }
        enlace.radioGroup3.setOnCheckedChangeListener { _, checkedId -> realizarOperacion(enlace, checkedId) }
    }

     fun realizarOperacion(enlace: ActivityMainBinding, checkedId: Int) {
        val numA = enlace.numeroA.text.toString().toDoubleOrNull() ?: return
        val numB = enlace.numeroB.text.toString().toDoubleOrNull() ?: return
        var resultado = ""

        when (checkedId) {
            enlace.suma.id -> resultado = (numA + numB).toString()
            enlace.resta.id -> resultado = (numA - numB).toString()
            enlace.multiplicacion.id -> resultado = (numA * numB).toString()
            enlace.division.id -> resultado = if (numB != 0.0) (numA / numB).toString() else "Error"
            enlace.raizA.id -> resultado = sqrt(numA).toString()
            enlace.raizB.id -> resultado = sqrt(numB).toString()
            enlace.logA.id -> resultado = if (numA > 0) log10(numA).toString() else "Error"
            enlace.logB.id -> resultado = if (numB > 0) log10(numB).toString() else "Error"
            enlace.mayor.id -> resultado = maxOf(numA, numB).toString()
            enlace.menor.id -> resultado = minOf(numA, numB).toString()
            enlace.divisible.id -> resultado = if (numA % numB == 0.0) "Sí" else "No"
            enlace.potencia.id -> resultado = numA.pow(numB).toString()
        }
        enlace.resultado.setText(resultado)
    }
}
