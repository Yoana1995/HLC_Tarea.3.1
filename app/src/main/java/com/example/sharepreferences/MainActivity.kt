package com.example.sharepreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guardar = findViewById<Button>(R.id.guardar)
        val borrar = findViewById<Button>(R.id.borrar)
        val ver = findViewById<Button>(R.id.ver)

        val prefs =getSharedPreferences("No hay datos", Context.MODE_PRIVATE)
        val editar = prefs.edit()

        guardar.setOnClickListener {
            editar.putString("id", findViewById<EditText>(R.id.id).text.toString()).apply()
            editar.putString("nombre", findViewById<EditText>(R.id.nom).text.toString()).apply()
            editar.putString("apellido", findViewById<EditText>(R.id.apel).text.toString()).apply()
            editar.putString("anyo", findViewById<EditText>(R.id.anyo).text.toString()).apply()
            Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
        }
        ver.setOnClickListener {
            val id = prefs.getString("id", "?")
            val nombre = prefs.getString("nombre", "?")
            val apellido = prefs.getString("apellido", "?")
            val anyo = prefs.getString("anyo", "?")
            Toast.makeText(this,"ID: "+id+" -> "+nombre+" "+apellido+" de "+anyo, Toast.LENGTH_SHORT).show()
        }
        borrar.setOnClickListener {
            editar.clear()
            editar.apply()
            Toast.makeText(this, "Datos borrados", Toast.LENGTH_SHORT).show()
        }
    }
}