package com.nesrin.mycook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nesrin.mycook.R
import com.nesrin.mycook.entities.Recipies


class SubChategoryAdapter : RecyclerView.Adapter<SubChategoryAdapter.RecipeViewHolder>() {

    private var arrSubChategory = ArrayList<Recipies>()

    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //val tv_dish_name: TextView = view.tv_dish_name
        public lateinit var tv_dish_name:TextView
    }

    fun setData(arrData: List<Recipies>) {
        arrSubChategory.clear()
        arrSubChategory.addAll(arrData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_sub_chategory,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return arrSubChategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.tv_dish_name.text = arrSubChategory[position].dishName
    }
}
