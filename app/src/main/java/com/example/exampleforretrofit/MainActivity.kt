package com.example.exampleforretrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleforretrofit.adapter.UserAdapter
import com.example.exampleforretrofit.model.user
import com.example.exampleforretrofit.network.RetrofitClient
import retrofit2.Response
import retrofit2.Callback
import retrofit2.Call


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        fetchUsers()
    }

    private fun fetchUsers() {
        val call = RetrofitClient.instance.getUsers()
        call.enqueue(object : Callback<List<user>> {
            override fun onResponse(call: Call<List<user>>, response: Response<List<user>>) {

               //Handle the error scenario here
                if (response.isSuccessful) {
                    // Update your UI with the list of users
                    val users = response.body()

                    if(users!=null){
                        userAdapter=UserAdapter(users)
                        recyclerView.adapter=userAdapter
                    }
                    users?.forEach { user ->
                        Log.d(
                            "USER_DATA",
                            "Name: ${user.name}, Email: ${user.email}, Phone: ${user.phone}"
                        )
                    }
                } else {
                    Log.e("API_ERROR", "Failed to fetch data")
                    //code for lese thing
                }
            }

            override fun onFailure(call: Call<List<user>>, t: Throwable) {
                //Handle the failure
                Log.e("NETWORK_ERROR", "Error: ${t.message}")
            }

        })
    }
}