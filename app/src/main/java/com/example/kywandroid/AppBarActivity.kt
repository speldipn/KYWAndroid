package com.example.kywandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.CollapsingToolbarLayout

class AppBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bar)
        val collapsingToolbarLayout: CollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar)
        collapsingToolbarLayout.title = "Collapsing"
        collapsingToolbarLayout.setExpandedTitleColor(0xffffffff.toInt())
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Hello Toolbar"
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener { item ->
            if(item.itemId == R.id.android) {
                Toast.makeText(this, "Hello Android", Toast.LENGTH_LONG).show()
                true
            } else {
                false
            }
        }
    }
}