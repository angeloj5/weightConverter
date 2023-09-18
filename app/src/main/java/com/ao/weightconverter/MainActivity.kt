package com.ao.weightconverter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
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
import java.text.DecimalFormat

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
        var txtResult : TextView = findViewById<TextView>(R.id.txtResult)
        var LsResult = ""
        var weightResult = 0.0

        btnConvert.setOnClickListener(View.OnClickListener {

            //We validate that a number has been entered
            if(txtWeightInput.text.toString()=="") {
                Toast.makeText(this, "You have to enter a number!", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }

            when(rdbConvertionGroup.checkedRadioButtonId){
                R.id.kp -> {
                    weightResult = txtWeightInput.text.toString().toFloat() * 2.20462262185
                    LsResult = "Pounds: " + weightResult.toString()
                }
                R.id.pk -> {
                    weightResult = txtWeightInput.text.toString().toFloat() / 2.20462262185
                    LsResult = "Kilos: " + weightResult.toString()
                }
                else -> {
                    Toast.makeText(this, "You have to select a conversion!", Toast.LENGTH_LONG).show()
                    return@OnClickListener
                }
            }
            txtResult.setText(LsResult)

            val LoClipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val LoClipData : ClipData = ClipData.newPlainText("Weight Result", weightResult.toString())

            LoClipboard.setPrimaryClip(LoClipData)
        })
    }
}