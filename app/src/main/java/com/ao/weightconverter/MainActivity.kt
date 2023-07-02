package com.ao.weightconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Filling spinner
        var spnConvertions:Spinner = findViewById(R.id.spnConvertions)

        ArrayAdapter.createFromResource(
            this,
            R.array.spnConvertions,
            android.R.layout.simple_spinner_item)
            .also{adapter->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spnConvertions.adapter=adapter
        }*/

        //Button click event
        var btnConvert:Button = findViewById<Button>(R.id.btnConvert)
        var rdbConvertionGroup : RadioGroup = findViewById<RadioGroup>(R.id.rdbConvertionGroup)
        var txtWeightInput : EditText = findViewById<EditText>(R.id.txtWeightInput)

        btnConvert.setOnClickListener(View.OnClickListener {
            when(rdbConvertionGroup.checkedRadioButtonId){
                R.id.kp -> {
                    var weightResult = Integer.parseInt(txtWeightInput.text.toString()) * 2.20462262185
                    Toast.makeText(this, "Pounds: " + weightResult, Toast.LENGTH_SHORT).show()
                }
                R.id.pk -> {
                    var weightResult = Integer.parseInt(txtWeightInput.text.toString()) / 2.20462262185
                    Toast.makeText(this, "Kilos: " + weightResult, Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
}