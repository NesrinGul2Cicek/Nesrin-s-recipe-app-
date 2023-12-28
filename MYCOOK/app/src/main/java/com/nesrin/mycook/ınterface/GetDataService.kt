package com.nesrin.mycook.ınterface

import com.nesrin.mycook.entities.Chategory
import com.nesrin.mycook.entities.converter.Meal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDataService {
    @GET("chategories.php")
    fun getCategoryList(): Call<List<Chategory>>

    @GET("filter.php")
    fun getMealList(@Query ("c") chategory:String) : Call<Meal>
}