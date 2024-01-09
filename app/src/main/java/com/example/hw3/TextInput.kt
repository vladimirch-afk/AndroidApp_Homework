package com.example.hw3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TextInput : AppCompatActivity() {
    private var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        button = findViewById(R.id.buttonToMain)
        button?.setOnClickListener{
            openTextEdit()
        }
    }

    private fun setTheme() {
        when (intent.getIntExtra("Theme_type", 0)) {
            0 -> {setTheme(R.style.Theme_PurpleTheme)}
            1 -> {setTheme(R.style.Theme_BlueTheme)}
            2 -> {setTheme(R.style.Theme_GreenTheme)}
            3 -> {setTheme(R.style.Theme_RedTheme)}
        }
        setContentView(R.layout.activity_text_input)
    }

    fun openTextEdit() {
        val intent = Intent(this, SettingsActivity::class.java).apply {
            val type = intent.getIntExtra("Theme_type", 0)
            putExtra("Theme_type", type)
        }
        startActivity(intent)
    }
}