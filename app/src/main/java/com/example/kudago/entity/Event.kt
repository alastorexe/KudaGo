package com.example.kudago.entity

import java.util.*

data class Event(
    val id: Int,
    val startDate: Date?,
    val endDate: Date?,
    val title: String,
    val placeId: Int,
    val description: String,
    val bodyText: String,
    val price: Double?,
    val images: List<String>
)