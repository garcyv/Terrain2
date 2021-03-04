package com.example.clase20012021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.clase20012021.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mbinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(mbinding.root)
    }
}