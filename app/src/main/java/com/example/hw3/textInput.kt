package com.example.hw3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class textInput : AppCompatActivity() {
    var textView: TextView? = null
    var editText: EditText? = null
    var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input)
        textView = findViewById<TextView>(R.id.showTextField)
        button = findViewById<Button>(R.id.buttonToMain)
        textView!!.text = intent.getStringExtra("TextFieldContent")
        button?.setOnClickListener{
            openTextEdit()
        }
    }

    fun openTextEdit() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}