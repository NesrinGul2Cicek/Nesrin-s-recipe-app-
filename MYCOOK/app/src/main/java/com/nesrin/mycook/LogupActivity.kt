package com.nesrin.mycook

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import com.google.firebase.auth.FirebaseAuth
import com.nesrin.mycook.databinding.ActivityLogupBinding

class LogupActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogupBinding
   // private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //firebaseAuth = FirebaseAuth.getInstance()


        binding.button4.setOnClickListener{
           val kayıtol =binding.button4.text.toString()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
                val email =binding.editTextTextemail.text.toString()
                val password =binding.editTextTextPassword3.text.toString()

                if( email.isNotEmpty()){
                    if(password.isNotEmpty()){

                       //  firebaseAuth.createUserWithEmailAndPassword(email,password).addCompleteListener{}
                        Toast.makeText(this,"Giriş başarılı", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this,"şifre kısmı boş", Toast.LENGTH_SHORT).show()
                    }


                }
                else{
                    Toast.makeText(this,"mail kısmı boş", Toast.LENGTH_SHORT).show()
                }
        }

    }

}