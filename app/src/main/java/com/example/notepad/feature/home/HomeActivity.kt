package com.example.notepad.feature.home

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.notepad.R
import com.example.notepad.databases.NoteDatabase
import com.example.notepad.databinding.ActivityHomeBinding
import com.example.notepad.feature.home.adapter.NoteAdapter
import com.example.notepad.feature.note.NoteActivity
import com.example.notepad.model.Note
import com.example.notepad.util.Utils

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val noteDatabase by lazy { NoteDatabase.getDatabase(this).noteDao() }
    private lateinit var dialog :Dialog
    private var listNote = listOf<Note>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initDialog()
        handleEvent()

        val launcherData = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){ result ->
            if(result.resultCode == NoteActivity.RESULT_CODE)
              observeNotes()
        }
    }
    override fun onRestart() {
        super.onRestart()

    }

    override fun onResume() {
        super.onResume()

        observeNotes()
    }

    private fun initDialog() {
        dialog = Utils.onCreateAnimDialogCenter(this, R.layout.custom_dialog,
            R.style.DialogSlideAnim, true
        )

    }
    private fun observeNotes(){
        listNote = noteDatabase.readAllDataDayUpdateDe()
        binding.rvNotes.adapter = NoteAdapter(this, listNote)
    }
    fun handleEvent(){
        binding.btnSort.setOnClickListener {
            dialog.show()
        }
        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, NoteActivity::class.java))
        }

    }

    //private fun initEvenListener(){
        //openDialogSort()
//    }
//    private fun openDialogSort(){
//        val listSort = arrayOf(
//            "edit date: from newest",
//            "edit date: from oldest",
//            "title: A to Z",
//        )
//        val mBuilder = AlertDialog.Builder(this)
//        mBuilder.setTitle("Choose an item")
//        mBuilder.setSingleChoiceItems(listSort, -1) { dialogInterface, i ->
//            Toast.makeText(this, listSort[i], Toast.LENGTH_SHORT).show()
//
//            when (i){
//                0 ->  listNote = noteDatabase.readAllDataDayUpdateDe()
//                1 ->  listNote = noteDatabase.readAllDataDayUpdateIn()
//                2 ->  listNote = noteDatabase.readAllDataTitleAtoZ()
//                3 ->  listNote = noteDatabase.readAllDataTitleZtoA()
//                4 ->  listNote = noteDatabase.readAllDataDayCreateDe()
//                5 ->  listNote = noteDatabase.readAllDataDayCreateIn()
//            }
//            binding.rvNotes.adapter = NoteAdapter(this, listNote)
//            dialogInterface.dismiss()
//        }
//        // Set the neutral/cancel button click listener
//        mBuilder.setNeutralButton("Cancel") { dialog, which ->
//            // Do something when click the neutral button
//            dialog.cancel()
//        }
//
//        val mDialog = mBuilder.create()
//        mDialog.show()
//    }


}