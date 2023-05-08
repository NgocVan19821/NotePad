package com.example.notepad.feature.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notepad.databinding.ActivityHomeBinding
import kotlinx.android.synthetic.main.activity_home.rvNotes

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}