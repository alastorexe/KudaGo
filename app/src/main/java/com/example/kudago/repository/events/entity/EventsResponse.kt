package com.example.kudago.repository.events.entity

import com.google.gson.annotations.SerializedName

data class EventsResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("result") val results: List<EventsDto>,
)

data class EventsDto(
    @SerializedName("id") val id: Int,
    @SerializedName("dates") val dates: List<EventsDateDto>,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("body_text") val bodyText: String,
    @SerializedName("price") val price: String,
    @SerializedName("images") val images: List<EventsImageDto>,
)

data class EventsDateDto(
    @SerializedName("start") val startDate: Long,
    @SerializedName("end") val endDate: Long,
)

data class EventsImageDto(
    @SerializedName("image") val image: String,
)