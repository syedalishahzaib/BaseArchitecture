package com.asrstudios.islamtoolkit.data.remote.response.prayertimes

import com.google.gson.annotations.SerializedName


data class Month(
    @SerializedName("en")
    val en: String,
    @SerializedName("number")
    val number: Int
)