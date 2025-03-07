package com.example.exampleforretrofit.network

import com.example.exampleforretrofit.model.user
import retrofit2.http.GET
import retrofit2.Call

 public interface ApiService{
    @GET("users")
    fun getUsers():Call<List<user>>
}
