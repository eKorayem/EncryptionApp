package com.example.encryptapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secondscreen: Button = findViewById(R.id.button)
        secondscreen.setOnClickListener(){
            val Intent = Intent(this,CaeserCipher::class.java)
            startActivity(Intent)
        }
        val threadscreen: Button = findViewById(R.id.button3)
        threadscreen.setOnClickListener(){
            val Intent2 = Intent(this,VigenereCipher::class.java)
            startActivity(Intent2)
        }
        val forcescreen: Button = findViewById(R.id.button4)
        forcescreen.setOnClickListener(){
            val Intent3 = Intent(this,supstitution::class.java)
            startActivity(Intent3)
        }
    }
}

