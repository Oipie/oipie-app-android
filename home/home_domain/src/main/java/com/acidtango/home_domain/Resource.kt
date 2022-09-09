package com.acidtango.home_domain

sealed class Resource<T>(val data: T? = null, val error: ErrorEntity? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(error: ErrorEntity) : Resource<T>(error = error)
}
