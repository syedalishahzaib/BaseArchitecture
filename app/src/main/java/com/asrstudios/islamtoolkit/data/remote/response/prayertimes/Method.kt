package com.asrstudios.islamtoolkit.data.remote.response.prayertimes

import com.google.gson.annotations.SerializedName


data class Method(
    @SerializedName("id")
    val id: Int,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String,
    @SerializedName("params")
    val params: Params
)