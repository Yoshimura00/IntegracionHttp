package com.example.integracionhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.integracionhttp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        searchByName("ID")
    }
    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://192.168.100.5:8080/JavaREST-1.0-SNAPSHOT/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    private fun searchByName(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call=getRetrofit().create(APIService::class.java).getUsers("hello-servlet")
            val usuarios = call.body()
            if(call.isSuccessful){
                //Show recycler view
                Log.i("Status","Todo OK")
                if (usuarios != null) {
                    Log.i("Status",usuarios.nombre.toString())
                }
            }
            else{
                //Show error
                Log.i("Status","No se pudo completar")
            }
        }
    }
}