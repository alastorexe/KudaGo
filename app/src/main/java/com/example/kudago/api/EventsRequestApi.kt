package com.example.kudago.api

import com.example.kudago.api.entity.EventsResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface EventsRequestApi {

    @GET("events")
    fun getEvents(
        @Query("location") location: String,
        @Query("fields") fields: String = "id,dates,title,place,price,description,images,body_text",
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int,
        @Query("order_by") orderBy: String = "-publication_date",
    ) : Observable<EventsResponse>
}