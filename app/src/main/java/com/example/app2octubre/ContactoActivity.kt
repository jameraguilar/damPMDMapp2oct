package com.example.app2octubre

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactoActivity : AppCompatActivity() {
    companion object{
        const val PARAMETRO_LOGIN = "parametro_login"
        const val PARAMETRO_EDAD ="parametro_edad"
    }
    private lateinit var btnVolver : Button
    private lateinit var login : String
    private lateinit var edad : String
    private lateinit var tvContacto : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contacto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initListener()
        login =intent.getStringExtra(PARAMETRO_LOGIN).orEmpty()
        edad = intent.getStringExtra(PARAMETRO_EDAD).orEmpty()
        tvContacto.setText(login+" "+edad)
    }
    private fun initComponents()
    {
        btnVolver = findViewById<Button>(R.id.btnVolver)
        tvContacto = findViewById<TextView>(R.id.tvContacto)
    }
    private fun initListener()
    {
        btnVolver.setOnClickListener {
            finish()
        }
    }
}