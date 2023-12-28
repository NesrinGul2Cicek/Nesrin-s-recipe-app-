package com.nesrin.mycook.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "MealItem")
data class MealItem(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name = "idmeal")
    @Expose
    @SerializedName("idMeal")
    val idmeal: String,

    @ColumnInfo(name = "strmeal")
    @Expose
    @SerializedName("strMeal")
    val strmeal: String,

    @ColumnInfo(name = "strmealthumb")
    @Expose
    @SerializedName("strMealThumb")
    val strmealthumb: String,


)
