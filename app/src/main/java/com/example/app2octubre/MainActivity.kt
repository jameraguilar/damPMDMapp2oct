package com.example.app2octubre

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var txtBienvenido : TextView
    private lateinit var btnA : Button
    private lateinit var btnB : Button
    private lateinit var btnC : Button
    private lateinit var ivFoto : ImageView
    private lateinit var etLogin : EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //llamamos al método inicializar componentes
        initComponents()
        //llamamos al método inicializar listener
        initListener()

    }
    private fun initComponents()
    {
         txtBienvenido = findViewById<TextView>(R.id.txtBienvenido)
         btnA = findViewById<Button>(R.id.btnA)
         btnB = findViewById<Button>(R.id.btnB)
         btnC = findViewById<Button>(R.id.btnC)
         etLogin = findViewById<EditText>(R.id.etLogin)
         ivFoto = findViewById<ImageView>(R.id.ivFoto)
    }
    private fun initListener()
    {
        btnA.setOnClickListener {
            txtBienvenido.setText("BIENVENIDO JAVI")
            //mostramos un mensaje durante dos segundos.
            Toast.makeText(this, "TEXTO CAMBIADO", 2).show()
        }
        btnB.setOnClickListener {
            ivFoto.setImageResource(R.drawable.foto2)
            //mostramos un mensaje durante dos segundos.
            Toast.makeText(this,"Foto cambiada",2).show()
        }
        //botonC me va a abrir la ventana
        btnC.setOnClickListener {
            val login = etLogin.text?.toString().orEmpty()
            if(login.isEmpty())
            {
                etLogin.error = "Introduce tu nombre"
                etLogin.requestFocus()
                return@setOnClickListener
            }

            val intent = Intent(this, ContactoActivity::class.java).apply{
                putExtra(ContactoActivity.PARAMETRO_LOGIN,login)
                putExtra(ContactoActivity.PARAMETRO_EDAD,"46")
            }
            startActivity(intent)
        }
    }


}