package com.example.encryptapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
var mode = 1
class VigenereCipher : AppCompatActivity() {
    var x = ""
    private val ENCRYPT = "ENCRYPT"
    private val DECRYPT = "DECRYPT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vigenere_cipher)

        val Mainscreen: ImageView = findViewById(R.id.back)
        Mainscreen.setOnClickListener(){
            val Intent = Intent(this,MainActivity::class.java)
            startActivity(Intent)
        }



        val convertbtn: Button = findViewById(R.id.convertbutton)
        val cleanbutton: Button = findViewById(R.id.cleanbutton)
        val textnpt: TextInputEditText = findViewById(R.id.textinputtwo)
        val Key: TextInputEditText = findViewById(R.id.Keyone)
        val output: TextInputEditText = findViewById(R.id.outputone)
        val todrobdown: AutoCompleteTextView = findViewById(R.id.dropdown)

        val listofbutton = listOf(ENCRYPT,DECRYPT)
        val adapter = ArrayAdapter(this , R.layout.drop_down_list_item , listofbutton)
        todrobdown.setAdapter(adapter)

        cleanbutton.setOnClickListener{
            Toast.makeText(this, "Cleaned", Toast.LENGTH_SHORT).show()
            textnpt.setText("")
            Key.setText("")
            output.setText("")
        }
        convertbtn.setOnClickListener{
            Toast.makeText(this, "Converted", Toast.LENGTH_SHORT).show()
            val textnpt2 = textnpt.text.toString()
            val Key2 = Key.text.toString()
            val field = todrobdown.text.toString()
            if (field == ENCRYPT){
                mode = 1
            }
            else if (field == DECRYPT){
                mode = 2
            }
            x=encode(textnpt2.lowercase(),Key2.lowercase())
            output.setText(x)}

        }
    }

    private fun encode(str: String,key1: String): String {
        val list1 = listOf('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z')
        var z= ""
        var y= ""

        var x = 0
        for (i in str) {
            if (key1.isEmpty()){
                z="Empty Key!!"
                break
            }
            if (i !in list1){
                y += i
                continue
            }

            if (y.length < str.length) {
                y += key1[x]
                x=(x+1) % key1.length
            }
        }




        for (i in 0 until  str.length) {
            if (key1.isEmpty()){
                z="Empty Key!!"
                break
            }

            if (y[i] !in list1) {
                z += str[i]
                continue
            }
            if (str[i] !in list1) {
                z += str[i]
                continue
            }

            val text2 = list1.indexOf(str[i])
            val key3 = list1.indexOf(y[i])
            var text3 = 1
            if (mode == 1){
                text3=(text2 + key3).mod(26)
            }
            else if (mode == 2){
                text3=(text2 - key3).mod(26)
            }
            if (str[i].isUpperCase()){
                z+=list1[text3].uppercase()
            }
            else{
                z+=list1[text3]
            }
        }
        return z
    }
