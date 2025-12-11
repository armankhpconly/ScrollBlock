package com.example.scrollblock


import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity)
        val instagram = findViewById<LinearLayout>(R.id.instagram)
        val youtube = findViewById<LinearLayout>(R.id.youtube)
        val snapchat = findViewById<LinearLayout>(R.id.snapchat)
        if (instagram != null) {

        }

findViewById<Button>(R.id.block).setOnClickListener {
            val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
            startActivity(intent)

        }
    }
}
