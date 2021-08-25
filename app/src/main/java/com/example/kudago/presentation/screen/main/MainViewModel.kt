package com.example.kudago.presentation.screen.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kudago.entity.City
import com.example.kudago.entity.Event
import com.example.kudago.repository.cities.CitiesNetworkSource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val eventsLiveData = MutableLiveData<List<Event>>()
    val citiesLiveData = MutableLiveData<List<City>>()
    val loaderCities = MutableLiveData<Boolean>()
    val citiesNetworkSource = CitiesNetworkSource()

    init {
        loadEvents()
    }

    fun loadEvents() {
        loaderCities.value = true

        citiesNetworkSource.getCities()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    loaderCities.value = false
                    citiesLiveData.value = it
                },
                {
                    // tima jopa error
                }
            )
    }
}