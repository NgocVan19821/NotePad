package com.example.notepad.feature.note

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.notepad.R
import com.example.notepad.databases.NoteDatabase
import com.example.notepad.databinding.ActivityNoteBinding
import com.example.notepad.extensions.getCurrentTime
import com.example.notepad.model.Note

class NoteActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_DATA_NAME = "extra_data_name"
        const val RESULT_CODE = 100
    }
    private lateinit var binding: ActivityNoteBinding
    private val noteDatabase by lazy { NoteDatabase.getDatabase(this).noteDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



    private fun initEventListener(){

    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBackPressed() {
        super.onBackPressed()
        val note = Note(
            0,
            binding.tvEditTitle.text.toString(),
            binding.tvEditContent.text.toString(),
            this.getCurrentTime(),
            this.getCurrentTime()

        )
        noteDatabase.insert(note)
        setResult(
            RESULT_CODE,
            Intent()
        )
        finish()
    }
}