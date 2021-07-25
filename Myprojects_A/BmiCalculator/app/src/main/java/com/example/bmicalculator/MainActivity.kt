package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultButton.setOnClickListener {

            val intent = Intent(this, ResultActivity::class.java)

            val strWeightValue : String = weightEditText.text.toString()
            val strHeightValue : String = heightEditText.text.toString()

            if (strWeightValue.isEmpty() || strHeightValue.isEmpty()) {
                Toast.makeText(this,"Value is null",Toast.LENGTH_SHORT).show()
            }
            else if (strHeightValue.toInt() == 0 || strWeightValue.toInt() == 0) {
                Toast.makeText(this, "Value should be not zero",Toast.LENGTH_SHORT).show()
            }
            else {
                //save data to edittext
                saveData(strHeightValue.toInt(),strWeightValue.toInt())

                //load data to intent
                intent.putExtra("weight", strWeightValue)
                intent.putExtra("height", strHeightValue)
                startActivity(intent)

                loadData()
            }
        }
        /*

        resultButton.setOnClickListener {
            startActivity<ResultActivity>(
                "weight" to weightEditText.text.toString(),
                "height" to heightEditText.text.toString()
            )
        }

         */
        }
    private fun saveData(height: Int, weight: Int) {

        val pref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        //위 코드를 사용하기 위해서는 build.gradle 에 implementation 'androidx.preference:preference-ktx:1.1.1' 코드 추가

        val editor = pref.edit()

        editor.putInt("KEY_HEIGHT", height)
            .putInt("KEY_WEIGHT", weight)
            .apply()
    }
    private fun loadData() {

        val pref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        val height = pref.getInt("KEY_HEIGHT" , 0)
        val weight = pref.getInt("KEY_WEIGHT", 0)

        if (height != 0 && weight != 0) {
            heightEditText.setText(height.toString())
            weightEditText.setText(weight.toString())
        }
    }
}

