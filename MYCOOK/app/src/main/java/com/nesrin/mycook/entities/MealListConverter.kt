package com.nesrin.mycook.entities

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.reflect.typeOf

class MealListConverter {
    @TypeConverter
    fun fromChategoryList(chategory: List<MealsItems>): String ?{
        if (chategory == null){
            return (null)
        }
        else{
            val gson  = Gson()
            val typo = object : TypeToken<MealsItems>(){

            }.type
            return gson.toJson(chategory)// ,type silindi .
        }
    }

    @TypeConverter
    fun toChategoryList (chategoryString: String):List<MealsItems>?{
        if(chategoryString == null){
            return (null)
        }
        else{
            val gson = Gson()
            val type = object : TypeToken<MealsItems>(){

            }.type
            return gson.fromJson(chategoryString,type)
        }

    }

 }