package com.asrstudios.islamtoolkit.netwrok.apiclients.prayertimes

import com.asrstudios.islamtoolkit.base.BaseRetrofitClient
import com.asrstudios.islamtoolkit.others.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class PrayerTimesApiClient @Inject constructor() : BaseRetrofitClient(){

    fun getPrayerTimesApi(): PrayerTimesApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.PRAYER_TIMES_BASE_URL)
            .build()
            .create(PrayerTimesApi::class.java)
    }
}