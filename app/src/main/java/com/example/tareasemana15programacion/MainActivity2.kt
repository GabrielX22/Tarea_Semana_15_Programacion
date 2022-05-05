package com.example.tareasemana15programacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //Se crea el evento clic del boton para finalizar el activity
        imageregresar.setOnClickListener {
            finish()
        }
    }
}