package com.nesrin.mycook.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Chategory")
data class Chategory(
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "categoriesitem")
    @Expose
    @SerializedName("Chategories")
    @TypeConverters(ChategoryListConverter::class)
    var categoriesitem: List<ChategoryItem>? = null
)
