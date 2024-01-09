package com.example.hw3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : Activity() {
    private var textViewName: TextView? = null
    private var button: Button? = null
    private var buttonSettings: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme()
        textViewName = findViewById(R.id.name)
        //editText = findViewById<EditText>(R.id.editTextField)
        button = findViewById(R.id.mainButton)
        buttonSettings = findViewById(R.id.button)
        button!!.setOnClickListener {
            openTextEdit()
        }
        buttonSettings!!.setOnClickListener {
            openSettings()
        }
        /*val thread = Thread {
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
        thread.start()*/
    }


    private fun setTheme() {
        when (intent.getIntExtra("Theme_type", 0)) {
            0 -> {setTheme(R.style.Theme_PurpleTheme)}
            1 -> {setTheme(R.style.Theme_BlueTheme)}
            2 -> {setTheme(R.style.Theme_GreenTheme)}
            3 -> {setTheme(R.style.Theme_RedTheme)}
        }
        setContentView(R.layout.activity_main)
    }

    private fun openTextEdit() {
        val intent = Intent(this, TextInput::class.java).apply {
            putExtra("Theme_type", intent.getIntExtra("Theme_type", 0))
        }
        startActivity(intent)
    }

    private fun openSettings() {
        val intent = Intent(this, SettingsActivity::class.java).apply {
            putExtra("Theme_type", intent.getIntExtra("Theme_type", 0))
        }
        startActivity(intent)
    }
}