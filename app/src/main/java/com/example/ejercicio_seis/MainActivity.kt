package com.example.ejercicio_seis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var txtTitle: TextView
    lateinit var spLenguaje: Spinner
    lateinit var txtDescripcion: TextView
    val lenguajes = arrayOf("PHP", "JAVA", "KOTLIN", "JAVASCRIPT", "RUBY", "C", "SWIFT")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTitle = findViewById(R.id.txtTitle)
        txtDescripcion = findViewById(R.id.txtDescripcion)
        spLenguaje = findViewById(R.id.spLenguaje)

        //crea el adaptador del spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, lenguajes)
        spLenguaje.adapter = adapter

        spLenguaje.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.v("App Spinner", "Select one $id")
        val select = lenguajes[position]

        txtTitle.text = select

        val descriptor = when (select) {
            "PHP" -> "Es lenguaje para el bockend de las paginas web"
            "JAVA" -> "Lenguaje de programacion POO"
            "KOTLIN" -> "Lenguaje de programacion para android"
            "JAVASCRIPT" -> "Es lenguaje para paginas web"
            "RUBY" -> "Es lenguaje para paginas web POO"
            "C" -> "El propósito es que sea eficiente, portable y fácil de mantener"
            "SWIFT" -> "Swift es un lenguaje de programación de propósito general"
            else -> "NO SE A DEFINIDO"
        }
        txtDescripcion.text = descriptor
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}