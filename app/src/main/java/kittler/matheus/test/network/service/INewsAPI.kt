package kittler.matheus.test.network.service

import kittler.matheus.test.model.Recover
import kittler.matheus.test.model.RecoverResponse
import kittler.matheus.test.model.resource.ApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface INewsAPI {

    @GET("data.json")
    fun getNewsAsync(): Deferred<ApiResponse<RecoverResponse>>
}