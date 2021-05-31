package com.gilbertopapa.network.api

sealed class ApiResponse<out Q> {

    data class Success<out T>(val data: T) : ApiResponse<T>()

    data class Error(val msg: String) : ApiResponse<Nothing>()
}