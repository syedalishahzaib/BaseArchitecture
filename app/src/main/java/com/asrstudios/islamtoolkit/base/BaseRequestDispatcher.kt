package com.asrstudios.islamtoolkit.base

import android.widget.Toast
import com.asrstudios.islamtoolkit.netwrok.ResponseException
import com.asrstudios.islamtoolkit.others.NetworkUtils

abstract class BaseRequestDispatcher constructor(
    private val remoteRepo: BaseRemoteRepository
) {
    suspend fun fetchData(
        requestFactory: BaseRequestFactory
    ): Any? {

        var errorMessage: String? = null;
        val response = try {
            val isNetworkConnected = NetworkUtils.isNetworkAvailable(requestFactory.getContext())
            if (isNetworkConnected) {
                remoteRepo.fetchDataFromNetwork(requestFactory)
            } else {
                errorMessage =
                    "Oops! Looks like your device is not connected to internet. Please check internet connectivity to proceed further."
                null
            }
        } catch (ex: Exception) {
            errorMessage = ex.message
            ex.printStackTrace()
            null
        }

        return if (response != null && (response.isSuccessful)) {
            val convertToBaseResonse = response.body()
            convertToBaseResonse?.success = response.isSuccessful
            convertToBaseResonse
        } else if (response != null && response.code().toString() == "401") {
             response
        } else if(response==null){
            Toast.makeText(requestFactory.getContext(),errorMessage,Toast.LENGTH_SHORT)
        }else {
            if (response?.code().toString().isNullOrEmpty()) throw Exception(response?.message())
            else {
                if(errorMessage==null && !response?.message().isNullOrEmpty()){
                    errorMessage = response?.message()
                }
                throw ResponseException(errorMessage ?: "", response!!.code())
            }
        }
    }

}