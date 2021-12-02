package com.asrstudios.islamtoolkit.data.remote.response.prayertimes

import com.google.gson.annotations.SerializedName


data class Location(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double
)