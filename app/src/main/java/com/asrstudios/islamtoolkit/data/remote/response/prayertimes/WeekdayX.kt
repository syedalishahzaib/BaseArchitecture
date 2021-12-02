package com.asrstudios.islamtoolkit.data.remote.response.prayertimes

import com.google.gson.annotations.SerializedName


data class WeekdayX(
    @SerializedName("ar")
    val ar: String,
    @SerializedName("en")
    val en: String
)