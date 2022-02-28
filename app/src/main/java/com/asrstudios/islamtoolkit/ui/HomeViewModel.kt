package com.asrstudios.islamtoolkit.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.asrstudios.islamtoolkit.base.BaseRequestDispatcher
import com.asrstudios.islamtoolkit.base.BaseViewModel
import com.asrstudios.islamtoolkit.data.remote.request.PrayerTimesRequest
import com.asrstudios.islamtoolkit.data.remote.response.prayertimes.PrayerTimesResponse
import com.asrstudios.islamtoolkit.di.clientfactory.HomeApiClientsFactory
import com.asrstudios.islamtoolkit.netwrok.dispatcher.HomeDispatcher
import com.asrstudios.islamtoolkit.netwrok.repository.HomeRequestFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeDispatcher: HomeDispatcher, private val homeApiClientsFactory: HomeApiClientsFactory) : BaseViewModel() {

    fun getPrayerTimings(){
        val prayerTimesRequest = PrayerTimesRequest("31.5204","74.3587","0","12")
        val prayerTimingsRequestFactory = HomeRequestFactory(homeApiClientsFactory.prayerTimesApiClient,prayerTimesRequest)

        fetchData(prayerTimingsRequestFactory,true){ response ->
            if(response is PrayerTimesResponse){
                Timber.d("getPrayerTimings: $response")
            }
        }
    }

    override fun getDispatcher() = homeDispatcher

}