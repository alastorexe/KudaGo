package com.example.kudago.repository.cities

import com.example.kudago.entity.City
import com.example.kudago.repository.RetrofitStorage
import io.reactivex.rxjava3.core.Observable

class CitiesNetworkSource {

    val citiesRequestApi = RetrofitStorage.retrofit.create(CitiesRequestApi::class.java)

    fun getCities(): Observable<List<City>> {
        return citiesRequestApi.getCities().map { cities ->
            cities.map { city ->
                City(
                    slug = city.slug,
                    name = city.name
                )
            }
        }
    }
}