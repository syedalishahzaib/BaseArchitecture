package com.asrstudios.islamtoolkit.di.clientfactory

import com.asrstudios.islamtoolkit.base.BaseApiClientRequestFactory
import com.asrstudios.islamtoolkit.netwrok.apiclients.prayertimes.PrayerTimesApiClient
import javax.inject.Inject


class  HomeApiClientsFactory@Inject constructor():BaseApiClientRequestFactory() {

    @Inject lateinit var prayerTimesApiClient : PrayerTimesApiClient

}