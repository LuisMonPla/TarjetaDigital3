package com.example.tarjetadigital3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Addusuario : AppCompatActivity() {

    lateinit var edNombre: EditText
    lateinit var edCarrera: EditText
    lateinit var edTelefono: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addusuario)


        edNombre = findViewById(R.id.etNombre)
        edCarrera = findViewById(R.id.etCarrera)
        edTelefono = findViewById(R.id.etTelefono)

        val nombre = intent.getStringExtra("Nombre")
        edNombre.setText(nombre)
        val carrera = intent.getStringExtra("Carrera")
        edCarrera.setText(carrera)
        val telefono = intent.getStringExtra("Telefono")
        edTelefono.setText(telefono)

    }
    fun guardarValor(v: View) {
        val preferencias = getSharedPreferences(
            "misdatos", Context.MODE_PRIVATE)
        val editor = preferencias.edit() //permite guardar
        val nombre = edNombre.text.toString()
        val carrera = edCarrera.text.toString()
        val telefono = edTelefono.text.toString()//obtener del cuadro
        editor.putString("Nombre", nombre)
        editor.putString("Carrera", carrera)
        editor.putString("Telefono", telefono)
        editor.commit()
        Toast.makeText(this, "Se grabo", Toast.LENGTH_LONG).show()


        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("Nombre", nombre)
        intent.putExtra("Carrera", carrera)
        intent.putExtra("Telefono", telefono)
        startActivity(intent)
    }
}