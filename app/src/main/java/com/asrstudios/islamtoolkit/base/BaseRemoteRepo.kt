package com.asrstudios.islamtoolkit.base

import android.content.Context
import com.asrstudios.islamtoolkit.data.remote.response.BaseResponseModel
import retrofit2.Response

abstract class BaseRemoteRepository {
    abstract suspend fun fetchDataFromNetwork(baseRequestFactory: BaseRequestFactory) : Response<out BaseResponseModel>?
}