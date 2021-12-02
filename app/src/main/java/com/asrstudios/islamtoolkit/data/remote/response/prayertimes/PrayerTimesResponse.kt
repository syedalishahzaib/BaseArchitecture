package com.asrstudios.islamtoolkit.data.remote.response.prayertimes

import com.asrstudios.islamtoolkit.base.BaseResponseModel
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class PrayerTimesResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: String
) :BaseResponseModel(), Serializable