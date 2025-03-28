package com.example.animalthread

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.animalthread.databinding.FragmentRootBinding

class RootActivity : AppCompatActivity() {

    private lateinit var binding: FragmentRootBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = FragmentRootBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}