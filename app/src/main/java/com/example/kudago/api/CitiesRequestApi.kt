package com.example.kudago.api

import com.example.kudago.api.entity.CityDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CitiesRequestApi {

    @GET("locations")
    fun getCities(
        @Query("fields") fields: String = "slag,name",
        @Query("order_by") orderBy: String = "slug",
    ) : Observable<List<CityDto>>
}