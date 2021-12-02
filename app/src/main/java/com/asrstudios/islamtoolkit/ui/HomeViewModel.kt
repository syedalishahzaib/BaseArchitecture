package com.asrstudios.islamtoolkit.ui

import androidx.lifecycle.ViewModel
import com.asrstudios.islamtoolkit.data.remote.request.PrayerTimesRequest
import com.asrstudios.islamtoolkit.di.clientfactory.HomeApiClientsFactory
import com.asrstudios.islamtoolkit.netwrok.dispatcher.HomeDispatcher
import com.asrstudios.islamtoolkit.netwrok.repository.HomeRequestFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeDispatcher: HomeDispatcher, private val homeApiClientsFactory: HomeApiClientsFactory) : ViewModel() {

    private fun getPrayerTimings(){
        val prayerTimesRequest = PrayerTimesRequest("","","0","12")
        val prayerTimingsRequestFactory = HomeRequestFactory(homeApiClientsFactory.prayerTimesApiClient,prayerTimesRequest)
        CoroutineScope(Dispatchers.IO).launch {
            homeDispatcher.fetchData(prayerTimingsRequestFactory)
        }
    }

}