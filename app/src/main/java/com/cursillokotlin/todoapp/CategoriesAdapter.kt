package com.cursillokotlin.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cursillokotlin.kotlin.R

class CategoriesAdapter(private val categories:List<TaskCategory>):
    RecyclerView.Adapter<CategoriesViewHolder>() {

    //Muestra el tamaño
    override fun getItemCount() = categories.size

    //inflador de vistas con un contexto
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoriesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task_category,parent,false))


    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position])
    }

}