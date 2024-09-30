package com.example.actividad2

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var inputTemperature: EditText
    private lateinit var btnCelsiusToFahrenheit: Button
    private lateinit var btnKelvinToCelsius: Button
    private lateinit var btnFahrenheitToKelvin: Button
    private lateinit var outputResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando los views
        inputTemperature = findViewById(R.id.input_temperature)
        btnCelsiusToFahrenheit = findViewById(R.id.btn_celsius_to_fahrenheit)
        btnKelvinToCelsius = findViewById(R.id.btn_kelvin_to_celsius)
        btnFahrenheitToKelvin = findViewById(R.id.btn_fahrenheit_to_kelvin)
        outputResult = findViewById(R.id.output_result)

        // Configurando listeners para los botones
        btnCelsiusToFahrenheit.setOnClickListener {
            if (validarCampo()) {
                val tempCelsius = inputTemperature.text.toString().toDouble()
                val tempFahrenheit = (9.0 / 5.0) * tempCelsius + 32
                outputResult.text = String.format("%.2f degrees Celsius is %.2f degrees Fahrenheit.", tempCelsius, tempFahrenheit)
            }
        }

        btnKelvinToCelsius.setOnClickListener {
            if (validarCampo()) {
                val tempKelvin = inputTemperature.text.toString().toDouble()
                val tempCelsius = tempKelvin - 273.15
                outputResult.text = String.format("%.2f degrees Kelvin is %.2f degrees Celsius.", tempKelvin, tempCelsius)
            }
        }

        btnFahrenheitToKelvin.setOnClickListener {
            if (validarCampo()) {
                val tempFahrenheit = inputTemperature.text.toString().toDouble()
                val tempKelvin = (5.0 / 9.0) * (tempFahrenheit - 32) + 273.15
                outputResult.text = String.format("%.2f degrees Fahrenheit is %.2f degrees Kelvin.", tempFahrenheit, tempKelvin)
            }
        }
    }

    // Método para validar el campo de entrada
    private fun validarCampo(): Boolean {
        if (TextUtils.isEmpty(inputTemperature.text)) {
            Toast.makeText(this, "Por favor, ingrese una temperatura", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
