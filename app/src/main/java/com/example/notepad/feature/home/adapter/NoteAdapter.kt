package com.example.notepad.feature.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notepad.databinding.ItemListBinding
import com.example.notepad.model.Note

class NoteAdapter(
    val context: Context,
    private val listNote:List<Note>

    ): RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {
    inner class MyViewHolder(var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        return MyViewHolder(
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listNote[position]
        if(item.title.isNullOrEmpty()){
            holder.binding.tvTitleNote.text = item.content
        }
        else{
            holder.binding.tvTitleNote.text = item.title
        }
      //  holder.binding.tvTitleNote.text = item.title
        holder.binding.tvDate.text = item.dateUpdate.toString()
    }
}