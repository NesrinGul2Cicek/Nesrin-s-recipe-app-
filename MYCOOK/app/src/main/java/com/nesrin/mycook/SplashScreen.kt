package com.nesrin.mycook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.nesrin.mycook.entities.Chategory
import com.nesrin.mycook.retrofitclient.RetrofitClientInstance
import com.nesrin.mycook.ınterface.GetDataService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.nesrin.mycook.R
import com.nesrin.mycook.database.RecipeDatabase
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks

class SplashScreen : BaseActivity() ,EasyPermissions.RationaleCallbacks , PermissionCallbacks{
    private var READ_STORAGE_PERM = 123
    public lateinit var btnGetStarted: Button
    public lateinit var loader:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        btnGetStarted.setOnClickListener {
            var intent = Intent(this@SplashScreen, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun getCategories() {
        val service = RetrofitClientInstance.retrofitInstance.create(GetDataService::class.java)
        val call = service.getCategoryList()

        call.enqueue(object : Callback<List<Chategory>> {
            override fun onResponse(
                call: Call<List<Chategory>>,
                response: Response<List<Chategory>>
            ) {
                loader.visibility = View.INVISIBLE

                if (response.isSuccessful) {
                    val categories = response.body()
                    insertDataIntoRoomDb(categories)
                } else {
                    Toast.makeText(this@SplashScreen, "Bir şeyler yanlış gitti", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<List<Chategory>>, t: Throwable) {
                loader.visibility = View.INVISIBLE
                Toast.makeText(this@SplashScreen, "Bir şeyler yanlış gitti", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


    fun getMeal() {
        val service = RetrofitClientInstance.retrofitInstance.create(GetDataService::class.java)
        val call = service.getCategoryList()

        call.enqueue(object : Callback<List<Chategory>> {
            override fun onResponse(
                call: Call<List<Chategory>>,
                response: Response<List<Chategory>>
            ) {
                loader.visibility = View.INVISIBLE

                if (response.isSuccessful) {
                    val categories = response.body()
                    insertDataIntoRoomDb(categories)
                } else {
                    Toast.makeText(this@SplashScreen, "Bir şeyler yanlış gitti", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<List<Chategory>>, t: Throwable) {
                loader.visibility = View.INVISIBLE
                Toast.makeText(this@SplashScreen, "Bir şeyler yanlış gitti", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    fun insertDataIntoRoomDb(category: Chategory?) {

        launch{
            this.let {
                RecipeDatabase.Companion.RecipeDatabase.getDatabase(this@SplashScreen).recipeDao().clearDb()
                for(arr in category!!.chategoriesitems!!){
                    RecipeDatabase.Companion.RecipeDatabase.getDatabase(this@SplashScreen)
                        .recipeDao().insertChategory(arr)
                }
                btnGetStarted.visibility = View.VISIBLE
            }
        }

    }

    private fun readStorageTask(){
        if(hasReadStoragePermission()){
            getCategories()
        }
        else{
            EasyPermissions.requestPermissions(
                this,
                "This app needs access to your storage,",
                READ_STORAGE_PERM,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
        }
    }

    private fun hasReadStoragePermission(): Boolean {
        return EasyPermissions.hasPermissions(
            this,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this)
    }

    override fun onRationaleAccepted(requestCode: Int) {
        TODO("Not yet implemented")
    }

    override fun onRationaleDenied(requestCode: Int) {
        TODO("Not yet implemented")
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        TODO("Not yet implemented")
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if(EasyPermissions.somePermissionPermanentlyDenied(this,perms)){
            AppSettingsDialog.Builder(this).build().show()
        }
    }
}
