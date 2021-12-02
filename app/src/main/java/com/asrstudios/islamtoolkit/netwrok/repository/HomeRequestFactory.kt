package com.asrstudios.islamtoolkit.netwrok.repository

import com.asrstudios.islamtoolkit.base.BaseRequestFactory
import com.asrstudios.islamtoolkit.base.BaseRequestParam
import com.asrstudios.islamtoolkit.base.BaseRetrofitClient

class HomeRequestFactory(private val retrofitClient : BaseRetrofitClient, private val requestParams: BaseRequestParam):BaseRequestFactory()  {

    override fun getRequestParam(): BaseRequestParam {
        return requestParams
    }

    override fun getApiClient(): BaseRetrofitClient {
        return retrofitClient
    }
}