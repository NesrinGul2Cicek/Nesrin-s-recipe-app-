package com.nesrin.mycook.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.nesrin.mycook.entities.Chategory
import com.nesrin.mycook.entities.Recipies

@Dao
interface RecipeDao {
    @get:Query("SELECT * FROM chategory ORDER BY id DESC ")
    val allChategory:List<Chategory>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipe(chategory: Chategory)

    @Query ("DELETE FROM chategoryitem")
    suspend fun clearDb()

}