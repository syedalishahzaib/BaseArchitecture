package com.asrstudios.islamtoolkit.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asrstudios.islamtoolkit.data.remote.response.BaseResponseModel
import com.asrstudios.islamtoolkit.netwrok.ResponseException
import kotlinx.coroutines.*

abstract class BaseViewModel : ViewModel() {

    private var fetchDataJobArray: ArrayList<Job> = ArrayList()
    abstract fun getDispatcher(): BaseRequestDispatcher?
    var showLoadingDialog: MutableLiveData<Boolean> = MutableLiveData()

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        if (throwable is ResponseException) {

        } else {

        }
        try {

        } catch (ex: Exception) {
            ex.message
        }
    }

    fun fetchData(
        requestFactory: BaseRequestFactory,
        showLoader: Boolean,
        proceedResponse: (t: Any?) -> Any
    ) {

        if (showLoader) {
            showLoadingDialog.postValue(true)
        }

        val fetchDataJob = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = getDispatcher()?.fetchData(requestFactory)
            withContext(Dispatchers.Main) {
                showLoadingDialog.postValue(false)
                response?.let {
                    if (it is BaseResponseModel) {
                        if (it.success) {
                            proceedResponse(response)
                        }
                    } else {
                        proceedResponse(response)
                    }
                }
            }
        }
        trackJob(fetchDataJob)
    }

    open fun trackJob(fetchDataJob: Job) {
        fetchDataJobArray.add(fetchDataJob)
    }

}