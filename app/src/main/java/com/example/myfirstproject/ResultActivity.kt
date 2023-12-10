package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassification = findViewById<TextView>(R.id.textview_Classification)
      val result =  intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /**IMC	Classificação
        Menor que 18,5	Magreza
        18,5 a 24,9	Normal
        25 a 29,9	Sobrepeso
        30 a 34,9	Obesidade grau I
        35 a 39,9	Obesidade grau II
        Maior que 40	Obesidade grau III
        */

        var classification = ""
        if (result < 18.5f) {
            classification = "Underweight"
        } else if ( result >= 18.5f && result <= 24.9f){
            classification = "Normal"
        }else if (result >= 25f && result <= 29.9f){
            classification ="Overweight"
        } else if ( result >= 30f && result <= 39.9f){
            classification ="Obese"
        } else {
            classification = "Obese Class III "
        }
       tvClassification.text = getString(R.string.message_classification,classification)


        }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}