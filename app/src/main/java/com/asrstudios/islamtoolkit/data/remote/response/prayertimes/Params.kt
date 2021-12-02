package com.asrstudios.islamtoolkit.data.remote.response.prayertimes



import com.google.gson.annotations.SerializedName


data class Params(
    @SerializedName("Fajr")
    val fajr: Int,
    @SerializedName("Isha")
    val isha: Int,
    @SerializedName("Maghrib")
    val maghrib: Int,
    @SerializedName("Midnight")
    val midnight: String
)