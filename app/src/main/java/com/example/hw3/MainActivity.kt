package com.example.hw3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MainActivity : Activity() {
    private var textViewName: TextView? = null
    private var button: Button? = null
    private var buttonSettings: Button? = null
    private var buttonMaps: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme()
        textViewName = findViewById(R.id.name)
        button = findViewById(R.id.mainButton)
        buttonSettings = findViewById(R.id.button)
        buttonMaps = findViewById(R.id.mapButton)
        button!!.setOnClickListener {
            openTextEdit()
        }
        buttonSettings!!.setOnClickListener {
            openSettings()
        }
        buttonMaps!!.setOnClickListener {
            openMaps()
        }
        val animation = AnimationUtils.loadAnimation(this, R.anim.tween_anim)
        textViewName!!.setOnClickListener { textViewName?.startAnimation(animation) }
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
        val intent = Intent(this, ListActivity::class.java).apply {
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

    private fun openMaps() {
        val intent = Intent(this, MapsActivity::class.java).apply {
            putExtra("Theme_type", intent.getIntExtra("Theme_type", 0))
        }
        startActivity(intent)
    }

}