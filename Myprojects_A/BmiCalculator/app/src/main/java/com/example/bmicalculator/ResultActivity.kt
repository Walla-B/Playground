package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height: Int = intent.getStringExtra("height")!!.toInt()
        val weight: Int = intent.getStringExtra("weight")!!.toInt()

        val bmi = weight / (height / 100.0).pow(2.0)

        when {
            bmi >= 35 -> resultTextView.text = "high"
            bmi >= 30 -> resultTextView.text = "mid - high"
            bmi >= 25 -> resultTextView.text = "intermed- high"
            bmi >= 23 -> resultTextView.text = "medium"
            bmi >= 18.5 -> resultTextView.text = "mid- low"
            else -> resultTextView.text = "very low"
        }

        when {
            bmi >= 23 -> imageView.setImageResource(
                R.drawable.ic_baseline_brightness_1_24)
            bmi >= 18.5 -> imageView.setImageResource(
                R.drawable.ic_baseline_brightness_2_24)
            else -> imageView.setImageResource(
                R.drawable.ic_baseline_brightness_3_24)
        }
    }
}