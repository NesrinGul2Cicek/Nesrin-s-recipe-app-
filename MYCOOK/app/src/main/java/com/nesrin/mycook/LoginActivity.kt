package com.nesrin.mycook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
//import com.google.firebase.auth.FirebaseAuth
import com.nesrin.mycook.LoginActivity
import com.nesrin.mycook.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    //private lateinit var firebaseAuth: FirebaseAuth//firebase sorunu çözülünce aktif etmeyi unutma
    override fun onCreate(savedInstanceState: Bundle?) {
       binding = ActivityLoginBinding.inflate(layoutInflater)
       setContentView(binding.root)
      // firebaseAuth = FirebaseAuth.getInstance()//firebase sorunu çözülünce aktif etmeyi unutma
        super.onCreate(savedInstanceState)
       binding.textView7.setOnClickListener{
            val intent0  = Intent(this,LogupActivity::class.java)
            startActivity(intent0)
         //  firebaseAuth = FirebaseAuth.getInstance()

       }
       binding.button4.setOnClickListener{
           val email =binding.editTextTextemail.text.toString()
           val password =binding.editTextTextPassword3.text.toString()

           if( email.isNotEmpty()){
               if(password.isNotEmpty()){
               //firebaseAuth.createUserWithEmailAndPassword(email,password).addCompleteListener{}
                       Toast.makeText(this,"Giriş başarılı",Toast.LENGTH_SHORT).show()
                   }
                   else{
                   Toast.makeText(this,"şifre kısmı boş",Toast.LENGTH_SHORT).show()
                   }


           }
           else{
               Toast.makeText(this,"mail kısmı boş",Toast.LENGTH_SHORT).show()
           }
       }
    }


}






































