package com.nesrin.mycook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nesrin.mycook.adapter.MainChategoryAdapter
import com.nesrin.mycook.adapter.SubChategoryAdapter
import com.nesrin.mycook.database.RecipeDatabase
import com.nesrin.mycook.entities.ChategoryItem

import com.nesrin.mycook.entities.Recipies
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {
    lateinit var rv_main_chategory:androidx.recyclerview.widget.RecyclerView
    lateinit var rv_sub_chategory:androidx.recyclerview.widget.RecyclerView
    var arrMainChategory = ArrayList<ChategoryItem>()//burası videodan farklı items diye bitirmedim item dedim
    var arrSubChategory = ArrayList<Recipies>()
    // Aktivitenin içinde veya bir Fragment içinde:
   // val rvMainChategory: RecyclerView = findViewById(R.id.rv_main_chategory)
    //val rvMainChategory:RecyclerView = findViewById(R.id.rv_sub_chategory)
    var  mainChategoryAdapter = MainChategoryAdapter()
    var  subChategoryAdapter = SubChategoryAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

getDataFromDb()

        mainChategoryAdapter.setData(arrMainChategory)

        arrSubChategory.add(Recipies(1,"beef and mustard pie"))
        arrSubChategory.add(Recipies(2,"Chicken and mushroom hotpot"))
        arrSubChategory.add(Recipies(3,"Banana pancakes"))
        arrSubChategory.add(Recipies(4,"Kebab"))

        subChategoryAdapter.setData(arrMainChategory)



        // Büyük harf küçük harf hatası düzeltildi: "LayoutManager" -> "layoutManager"
       // rv_main_chategory.layoutManager = ListenerLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


// Büyük harf küçük harf hatası düzeltildi: "LayoutManager" -> "layoutManager"
        rv_sub_chategory.layoutManager = ListenerLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_sub_chategory.adapter = subChategoryAdapter




    }

    private fun getDataFromDb(){
        launch{
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllChategory()
                arrMainChategory = cat as ArrayList<ChategoryItem>
                arrMainChategory.reverse()
                mainChategoryAdapter.setData(arrMainChategory)
                rv_main_chategory.layoutManager = ListenerLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                rv_main_chategory.adapter = mainChategoryAdapter
            }

        }
    }


}