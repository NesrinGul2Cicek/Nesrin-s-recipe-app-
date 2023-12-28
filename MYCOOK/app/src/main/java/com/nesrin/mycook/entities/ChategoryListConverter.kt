package com.nesrin.mycook.entities

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.reflect.typeOf

class ChategoryListConverter {
    @TypeConverter
    fun fromChategoryList(chategory: List<Chategory>): String ?{
        if (chategory == null){
            return (null)
        }
        else{
            val gson  = Gson()
            val typo = object : TypeToken<Chategory>(){

            }.type
            return gson.toJson(chategory)// ,type silindi .
        }
    }

    @TypeConverter
    fun toChategoryList (chategoryString: String):List<Chategory>?{
        if(chategoryString == null){
            return (null)
        }
        else{
            val gson = Gson()
            val type = object : TypeToken<Chategory>(){

            }.type
            return gson.fromJson(chategoryString,type)
        }

    }

 }