package com.example.idealcity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    private val splashTimeOut : Long = 2000 //3초간 보여 주고 넘어 간다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler().postDelayed({
            //어떤 액티비티로 넘어 갈지 설정
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(R.anim.fadein,R.anim.fadeout)
            finish()
        }, splashTimeOut)
    }
}

