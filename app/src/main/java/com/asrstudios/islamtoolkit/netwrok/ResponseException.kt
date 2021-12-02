package com.asrstudios.islamtoolkit.netwrok

import com.google.gson.annotations.SerializedName

data class ResponseException(
    @SerializedName("message")
    override var message: String = "",
    @SerializedName("responseCode")
    var responseCode: Int = 0,
    @SerializedName("endPoint")
    var endPoint: String = ""
) : Exception()