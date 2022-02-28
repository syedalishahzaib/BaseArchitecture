package com.asrstudios.islamtoolkit.base

import android.content.Context

abstract class BaseRequestFactory() {

    abstract fun getRequestParam(): BaseRequestParam
    abstract fun getApiClient(): BaseRetrofitClient
    abstract fun getContext(): Context
}