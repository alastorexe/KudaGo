package com.example.kudago.repository

import com.example.kudago.helper.BASE_URL
import retrofit2.Retrofit

object RetrofitStorage {

    val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()

}