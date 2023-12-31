package com.example.myfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val edtWeight: EditText = findViewById(R.id.editext_weight)
        val edtHeight: EditText = findViewById(R.id.edittext_height)
        val tvResult: TextView = findViewById(R.id.textMsg)

        btnCalculate.setOnClickListener {
            // Recuperar a msg do usuario
            //val message : String =edtWeight.text.toString()

            // Aqui eu mostro uma nova msg textview

            val heightStr = edtHeight.text.toString()
            val weightStr = edtWeight.text.toString()

            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {


                val height: Float = edtHeight.text.toString().toFloat()
                val finalHeight: Float = height * height
                val weight: Float = edtWeight.text.toString().toFloat()
                val result: Float = weight / finalHeight

                tvResult.text = result.toString()
                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {

                Toast.makeText(this, "Fill in all sections", Toast.LENGTH_LONG).show();

            }
        }
    }
}