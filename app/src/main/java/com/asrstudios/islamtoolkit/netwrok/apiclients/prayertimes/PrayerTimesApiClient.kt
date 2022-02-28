package com.asrstudios.islamtoolkit.netwrok.apiclients.prayertimes

import android.content.Context
import com.asrstudios.islamtoolkit.base.BaseRetrofitClient
import com.asrstudios.islamtoolkit.others.Constants
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class PrayerTimesApiClient @Inject constructor(@ApplicationContext context : Context) : BaseRetrofitClient(context){

    lateinit var client : PrayerTimesApi
    fun getPrayerTimesApi(): PrayerTimesApi {
        return if(this::client.isInitialized) {
            client
        }else{
            client = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.PRAYER_TIMES_BASE_URL)
                .client(okHttpClient)
                .build()
                .create(PrayerTimesApi::class.java)
            client
        }

    }
}