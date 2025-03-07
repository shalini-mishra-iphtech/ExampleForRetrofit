package com.example.exampleforretrofit.network

import com.example.exampleforretrofit.model.UserData
import retrofit2.http.GET
import retrofit2.Call

 public interface ApiService{
    @GET("users")
    fun getUsers():Call<List<UserData>>
}
