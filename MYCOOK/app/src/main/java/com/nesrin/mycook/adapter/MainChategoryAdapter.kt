package com.nesrin.mycook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nesrin.mycook.R
import com.nesrin.mycook.entities.ChategoryItem
import com.nesrin.mycook.entities.Recipies




class MainChategoryAdapter : RecyclerView.Adapter<MainChategoryAdapter.RecipeViewHolder>() {
//public lateinit var tv_dish_name:TextView
     var arrMainChategory = ArrayList<ChategoryItem>()
    var ctx:Context? = null
lateinit var tv_dish_name:TextView
    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
       // val tv_dish_name: TextView = view.tv_dish_name
        public lateinit var tv_dish_name:TextView
    }

    fun setData(arrData: List<ChategoryItem>) {
       // arrMainChategory.clear()
       // arrMainChategory.addAll(arrData)
       // notifyDataSetChanged()
        arrMainChategory = arrData as ArrayList<ChategoryItem>

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        ctx = parent.context
        return RecipeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_chategory, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrMainChategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.itemView.tv_dish_name.text = arrMainChategory[position].strchategory
        Glide.with(ctx!!).load(arrMainChategory[position].strchategorythumb).into(holder.itemView)
    }
}
