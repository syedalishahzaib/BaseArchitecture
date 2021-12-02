package com.asrstudios.islamtoolkit.base

import retrofit2.Response

abstract class BaseRemoteRepository {
    abstract suspend fun fetchDataFromNetwork(baseRequestFactory: BaseRequestFactory) : Response<out BaseResponseModel>?
}