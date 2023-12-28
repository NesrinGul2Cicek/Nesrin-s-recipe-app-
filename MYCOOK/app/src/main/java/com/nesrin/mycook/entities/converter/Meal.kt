package com.nesrin.mycook.entities.converter

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nesrin.mycook.entities.MealListConverter
import com.nesrin.mycook.entities.MealsItems


@Entity(tableName = "Meal")
class Meal {

    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "meals")
    @Expose
    @SerializedName("Meals")
    @TypeConverters(MealListConverter::class)
    var mealsItem: List<MealsItems>? = null


}
