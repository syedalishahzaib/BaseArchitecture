package com.asrstudios.islamtoolkit.base

abstract class BaseRequestFactory() {

    abstract fun getRequestParam(): BaseRequestParam
    abstract fun getApiClient(): BaseRetrofitClient
}