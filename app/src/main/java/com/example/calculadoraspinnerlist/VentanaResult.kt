package com.example.calculadoraspinnerlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadoraspinnerlist.databinding.ActivityMainBinding
import com.example.calculadoraspinnerlist.databinding.ActivityVentanaResultBinding

class VentanaResult : AppCompatActivity() {
    lateinit var binding: ActivityVentanaResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVentanaResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recoger = intent.getStringExtra("rebs")
        binding.txtresultado.text=recoger
    }
}