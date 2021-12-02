package com.asrstudios.islamtoolkit.data.remote.request

import com.asrstudios.islamtoolkit.base.BaseRequestParam

data class PrayerTimesRequest(
    val latitude: String,
    val longitude: String,
    val method: String,
    val month: String
):BaseRequestParam()