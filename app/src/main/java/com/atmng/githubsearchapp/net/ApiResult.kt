package com.atmng.githubsearchapp.net

import retrofit2.HttpException
import retrofit2.Response

sealed class ApiResult<T> {
    class Success<T>(val data: T) : ApiResult<T>()
    class Failure<T>(val code: Int, val message: String?) : ApiResult<T>()
    class Exception<T>(val e: Throwable) : ApiResult<T>()
}

fun <T> Response<T>.execute(): ApiResult<T> {
    return try {
        when {
            isSuccessful && body() != null -> ApiResult.Success(body()!!)
            else -> ApiResult.Failure(code(), message())
        }
    } catch (e: HttpException) {
        ApiResult.Failure(code = e.code(), message = e.message())
    } catch (e: Throwable) {
        ApiResult.Exception(e = e)
    }
}

suspend fun <V> ApiResult<V>.onSuccess(block: suspend (value: V) -> Unit): ApiResult<V> {
    if (this is ApiResult.Success) block(data)
    return this
}

suspend fun <V> ApiResult<V>.onFailure(block: suspend (value: ApiResult.Failure<V>) -> Unit): ApiResult<V> {
    if (this is ApiResult.Failure) block(this)
    return this
}

fun <V> ApiResult<V>.getValue(): V? {
    return if (this is ApiResult.Success) data
    else null
}