package com.example.hw3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var textViewName: TextView? = null
    var textView: TextView? = null
    var editText: EditText? = null
    var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewName = findViewById<TextView>(R.id.name)
        editText = findViewById<EditText>(R.id.editTextField)
        button = findViewById<Button>(R.id.mainButton)
        button!!.setOnClickListener {
            openTextEdit()
        }
        val thread = Thread {
            var acc = -0.2f
            var vel = 2f
            val offsetY = textViewName!!.translationY
            while (true) {
                textViewName!!.translationY = textViewName!!.translationY + vel
                vel += acc
                if (textViewName!!.translationY > offsetY) {
                    acc = -0.2f
                }
                if (textViewName!!.translationY >= offsetY + 30) {
                    vel = -2f
                    textViewName!!.translationY = offsetY + 30
                }
                if (textViewName!!.translationY < offsetY) {
                    acc = 0.2f
                }
                if (textViewName!!.translationY < offsetY - 30) {
                    vel = 2f
                    textViewName!!.translationY = offsetY - 30
                }
                try {
                    Thread.sleep(20)
                } catch (e: Exception) {
                    throw RuntimeException()
                }
            }
        }
        thread.start()
    }

    fun openTextEdit() {
        val intent = Intent(this, textInput::class.java).apply {
            putExtra("TextFieldContent", editText!!.text.toString())
        }
        startActivity(intent)
    }
}