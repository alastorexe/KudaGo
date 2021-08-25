package com.example.kudago.repository.events

import com.example.kudago.entity.Event
import com.example.kudago.repository.RetrofitStorage
import io.reactivex.rxjava3.core.Observable
import java.util.*

class EventsNetworkSource {

    val eventsRequestApi = RetrofitStorage.retrofit.create(EventsRequestApi::class.java)

    fun getEvents(city: String, page: Int, pageSize: Int): Observable<List<Event>> {
        return eventsRequestApi.getEvents(location = city, page = page, pageSize = pageSize).map { events ->
            events.results.map { event ->
                Event(
                    id = event.id,
                    startDate = event.dates.firstOrNull()?.startDate?.let { Date(it) },
                    endDate = event.dates.firstOrNull()?.endDate?.let { Date(it) },
                    title = event.title,
                    description = event.description,
                    bodyText = event.bodyText,
                    price = event.price.toDoubleOrNull(),
                    images = event.images.map {
                        it.image
                    }
                )
            }
        }
    }
}