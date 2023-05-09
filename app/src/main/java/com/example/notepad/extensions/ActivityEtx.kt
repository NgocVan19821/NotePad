package com.example.notepad.extensions

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun Activity.getCurrentTime(): String{
    //get datetime now
    val current = LocalDateTime.now()
    //formatter datetime
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
    return current.format(formatter)
}

fun Activity.intentTo(activity: Activity){
    startActivity(Intent(this, Activity::class.java))
}