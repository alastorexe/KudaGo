package com.example.kudago.repository.cities.entity

import com.google.gson.annotations.SerializedName

data class CityDto(
    @SerializedName("slug") val slug: String,
    @SerializedName("name") val name: String,
)