package com.example.hw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class ListActivity : AppCompatActivity() {
    private val images = mutableListOf<Image>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme()
        setData()
        val debug = findViewById<TextView>(R.id.debug)
        debug.text = images.toString()
        val recyclerView = findViewById<RecyclerView>(R.id.review1)
        val adapter = CustomRecyclerAdapter(this, images)
        recyclerView.adapter = adapter
    }
    private fun setData() {
        for (i in 1..150) images.add(Image("Person #$i", i))
    }

    private fun setTheme() {
        when (intent.getIntExtra("Theme_type", 0)) {
            0 -> {setTheme(R.style.Theme_PurpleTheme)}
            1 -> {setTheme(R.style.Theme_BlueTheme)}
            2 -> {setTheme(R.style.Theme_GreenTheme)}
            3 -> {setTheme(R.style.Theme_RedTheme)}
        }
        setContentView(R.layout.activity_list)
    }
}