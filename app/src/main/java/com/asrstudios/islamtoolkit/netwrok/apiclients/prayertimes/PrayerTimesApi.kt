package com.asrstudios.islamtoolkit.netwrok.apiclients.prayertimes

import com.asrstudios.islamtoolkit.data.remote.response.prayertimes.PrayerTimesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PrayerTimesApi {

    @GET("v1/calendar")
    suspend fun fetchPrayerTimes(
        @Query("latitude") lat: String,
        @Query("longitude") long: String,
        @Query("method") method: String,
        @Query("month") month: String
    ): Response<PrayerTimesResponse>?

}