package com.nesrin.mycook.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "ChategoryItem")
data class ChategoryItem(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name = "idchategory")
    @Expose
    @SerializedName("idChategory")
    val idchategory: String,

    @ColumnInfo(name = "strchategory")
    @Expose
    @SerializedName("strChategory")
    val strchategory: String,

    @ColumnInfo(name = "strchategorythumb")
    @Expose
    @SerializedName("strChategoryThumb")
    val strchategorythumb: String,

    @ColumnInfo(name = "strchategorydescription")
    @Expose
    @SerializedName("strChategoryDescription")
    val strchategorydescription: String
)
