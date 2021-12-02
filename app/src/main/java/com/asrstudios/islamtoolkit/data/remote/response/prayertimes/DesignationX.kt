package com.asrstudios.islamtoolkit.data.remote.response.prayertimes

import com.google.gson.annotations.SerializedName


data class DesignationX(
    @SerializedName("abbreviated")
    val abbreviated: String,
    @SerializedName("expanded")
    val expanded: String
)