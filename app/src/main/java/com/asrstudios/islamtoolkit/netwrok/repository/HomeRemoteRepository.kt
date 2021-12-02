package com.asrstudios.islamtoolkit.netwrok.repository

import com.asrstudios.islamtoolkit.base.BaseRemoteRepository
import com.asrstudios.islamtoolkit.base.BaseRequestFactory
import com.asrstudios.islamtoolkit.base.BaseResponseModel
import com.asrstudios.islamtoolkit.data.remote.request.PrayerTimesRequest
import com.asrstudios.islamtoolkit.netwrok.apiclients.prayertimes.PrayerTimesApiClient
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Response
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class HomeRemoteRepository @Inject constructor(): BaseRemoteRepository() {
    override suspend fun fetchDataFromNetwork(baseRequestFactory: BaseRequestFactory): Response<out BaseResponseModel>? {
        return when (val apiClient = baseRequestFactory.getApiClient()) {
            is PrayerTimesApiClient -> {
                val prayerTimesRequest =
                    baseRequestFactory.getRequestParam() as PrayerTimesRequest
                apiClient.getPrayerTimesApi().fetchPrayerTimes(
                    prayerTimesRequest.latitude,
                    prayerTimesRequest.longitude,
                    prayerTimesRequest.method,
                    prayerTimesRequest.month
                )
            }
            else -> {
                null
            }
        }
    }
}