package com.nesrin.mycook.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nesrin.mycook.dao.RecipeDao
import com.nesrin.mycook.entities.Chategory
import com.nesrin.mycook.entities.ChategoryItem
import com.nesrin.mycook.entities.ChategoryListConverter
import com.nesrin.mycook.entities.MealListConverter
import com.nesrin.mycook.entities.MealsItems
import com.nesrin.mycook.entities.Recipies
import com.nesrin.mycook.entities.converter.Meal


abstract class RecipeDatabase:RoomDatabase() {
    companion object{
         var recipeDatabase:RecipeDatabase? = null

        @Database(entities = [Recipies::class,ChategoryItem::class,ChategoryListConverter::class,Meal::class, MealsItems::class,Chategory::class], version =1,exportSchema = false)
        @TypeConverters(ChategoryListConverter::class,MealListConverter::class)
abstract class RecipeDatabase: RoomDatabase(){


    companion object{

        var recipeDatabase: RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if(com.nesrin.mycook.database.RecipeDatabase.recipeDatabase == null){
                com.nesrin.mycook.database.RecipeDatabase.recipeDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return com.nesrin.mycook.database.RecipeDatabase.recipeDatabase!!
        }
    }
            abstract  fun recipeDao():RecipeDao
}

    }


}