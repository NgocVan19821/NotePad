package com.example.notepad.util

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import com.example.notepad.R

object Utils {
    fun onCreateAnimDialogCenter(
        applicationContext: Context?, layoutId: Int, animId: Int, isCanceledOnTouchOutside: Boolean = true
    ): Dialog {
        val dialog = Dialog(applicationContext!!, animId)
        dialog.setContentView(layoutId)
        dialog.setCancelable(isCanceledOnTouchOutside)
        dialog.window!!.setGravity(Gravity.CENTER)
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawableResource(R.color.transparent)
        return dialog
    }
}