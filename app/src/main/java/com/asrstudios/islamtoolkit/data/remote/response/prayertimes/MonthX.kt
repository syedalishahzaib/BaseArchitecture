package com.asrstudios.islamtoolkit.data.remote.response.prayertimes



import com.google.gson.annotations.SerializedName


data class MonthX(
    @SerializedName("ar")
    val ar: String,
    @SerializedName("en")
    val en: String,
    @SerializedName("number")
    val number: Int
)