package com.example.encryptapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class supstitution : AppCompatActivity() {
    var x = ""
    private val ENCRYPT = "ENCRYPT"
    private val DECRYPT = "DECRYPT"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supstitution)

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
        Key.setText("avsdwqertfgcboipkylnzxmhju")
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
                x=encode(textnpt2,Key2)
            }
            else if (field == DECRYPT){
                x=decode(textnpt2,Key2)
            }
            output.setText(x)
        }
    }

    private fun encode(str: String,key1: String): String {
        var alphabet = "abcdefghijklmnopqrstuvwxyz"
        var z= ""
        var index = 0

        for (char in str.lowercase()) {
            if (key1.isEmpty()) {
                z = "Empty Key!!"
                break
            }
            if (key1[index] !in alphabet || key1.length <26) {
                z = "Invaild Key!!"
                break
            }
            if (char !in alphabet) {
                z += char
                continue
            }
            val loc = alphabet.indexOf(char.toString())
            z += key1[loc]
            index += 1

        }
        return z

    }
    private fun decode(str: String,key1: String): String {
        var alphabet = "abcdefghijklmnopqrstuvwxyz"
        var z= ""
        var index = 0

        for (char in str.lowercase()) {
            if (key1.isEmpty()) {
                z = "Empty Key!!"
                break
            }
            if (key1[index] !in alphabet || key1.length <26) {
                z = "Invaild Key!!"
                break
            }
            if (char !in alphabet) {
                z += char
                continue
            }
            val loc = key1.indexOf(char.toString())
            z += alphabet[loc]
            index += 1

        }
        return z

    }

}

