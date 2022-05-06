package com.santeliz.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.text.set

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        define of var and const
        val _celsiusToFahrenheit : RadioButton = findViewById(R.id.celsiusToFahrenheit)
        val _fahrenheitToCelsius : RadioButton = findViewById(R.id.fahrenheitToCelsius)
        val _inputConverter : EditText = findViewById(R.id.inputConverter)
        val _convertButton : Button = findViewById(R.id.convertButton)

        var _convertedResult : TextView = findViewById(R.id.convertedResult)

//       event button click
        with(_convertButton) {
            setOnClickListener {
//               clear focus
                _inputConverter.clearFocus()
                if(_inputConverter.text.isEmpty()) {
//                    input is empty
                    _inputConverter.requestFocus()
                    Toast.makeText(applicationContext, "Se esperaba un dato", Toast.LENGTH_SHORT).show()
                } else if(_inputConverter.text.toString() == ".") {
                    _inputConverter.requestFocus()
                    Toast.makeText(application, "Ingrese un digito antes o despues del punto", Toast.LENGTH_SHORT).show()
                } else {
                    if(_celsiusToFahrenheit.isChecked) {
//                        convert celsius to fahrenheit
                        _convertedResult.text = "${_inputConverter.text.toString().toDouble()} grados Celcius es igual a " +
                                "${(_inputConverter.text.toString().toDouble() * 1.8 + 32)} grados Fahrenheit"
                    } else if(_fahrenheitToCelsius.isChecked) {
//                        convert fahrenheit to celsius
                        _convertedResult.text = "${_inputConverter.text.toString().toDouble()} grados Fahrenheit es igual a " +
                                "${((_inputConverter.text.toString().toDouble() - 32) / 1.8 )} grados Celsius"
                    }

                }
            }
        }

    }
}