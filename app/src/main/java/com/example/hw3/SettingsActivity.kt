package com.example.hw3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.RadioButton
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import kotlinx.coroutines.Dispatchers

class SettingsActivity : AppCompatActivity(){
    var buttonThemeRed : RadioButton? = null
    var buttonThemeGreen : RadioButton? = null
    var buttonThemeBlue: RadioButton? = null
    var buttonThemePurple : RadioButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme()
        val callback = object : OnBackPressedCallback(
            true // default to enabled
        ) {
            override fun handleOnBackPressed() {
                openMain()
            }
        }
        onBackPressedDispatcher.addCallback(
            this, // LifecycleOwner
            callback
        )
        setRadioButtons()
    }

    private fun setRadioButtons() {
        buttonThemeRed = findViewById(R.id.radioButtonRed)
        buttonThemeGreen = findViewById(R.id.radioButtonGreen)
        buttonThemeBlue = findViewById(R.id.radioButtonBlue)
        buttonThemePurple = findViewById(R.id.radioButtonPurple)

        buttonThemeRed!!.setOnClickListener { setRedTheme() }
        buttonThemeGreen!!.setOnClickListener { setGreenTheme() }
        buttonThemeBlue!!.setOnClickListener { setBlueTheme() }
        buttonThemePurple!!.setOnClickListener { setPurpleTheme() }

        when (intent.getIntExtra("Theme_type", 0)) {
            0 -> {
                setTheme(R.style.Theme_PurpleTheme)
                buttonThemePurple!!.isChecked = true
            }
            1 -> {
                setTheme(R.style.Theme_BlueTheme)
                buttonThemeBlue!!.isChecked = true
            }
            2 -> {
                setTheme(R.style.Theme_GreenTheme)
                buttonThemeGreen!!.isChecked = true
            }
            3 -> {
                setTheme(R.style.Theme_RedTheme)
                buttonThemeRed!!.isChecked = true
            }
        }
    }

    private fun setTheme() {
        when (intent.getIntExtra("Theme_type", 0)) {
            0 -> {setTheme(R.style.Theme_PurpleTheme)}
            1 -> {setTheme(R.style.Theme_BlueTheme)}
            2 -> {setTheme(R.style.Theme_GreenTheme)}
            3 -> {setTheme(R.style.Theme_RedTheme)}
        }
        setContentView(R.layout.activity_settings)
    }

    private fun setRedTheme() {
        setTheme(R.style.Theme_RedTheme)
        intent.putExtra("Theme_type", 3)
        openSettings()
    }

    private fun setGreenTheme() {
        setTheme(R.style.Theme_GreenTheme)
        intent.putExtra("Theme_type", 2)
        openSettings()
    }

    private fun setBlueTheme() {
        setTheme(R.style.Theme_BlueTheme)
        intent.putExtra("Theme_type", 1)
        openSettings()
    }

    private fun setPurpleTheme() {
        setTheme(R.style.Theme_PurpleTheme)
        intent.putExtra("Theme_type", 0)
        openSettings()
    }

    private fun openSettings() {
        val intent = Intent(this, SettingsActivity::class.java).apply {
            putExtra("Theme_type", intent.getIntExtra("Theme_type", 0))
        }
        startActivity(intent)
    }

    private fun openMain() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("Theme_type", intent.getIntExtra("Theme_type", 0))
        }
        startActivity(intent)
    }
}