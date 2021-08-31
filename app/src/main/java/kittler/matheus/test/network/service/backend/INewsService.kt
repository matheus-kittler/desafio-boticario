package kittler.matheus.test.network.service.backend

import kittler.matheus.test.model.New
import kittler.matheus.test.model.Recover
import kittler.matheus.test.model.RecoverResponse
import kittler.matheus.test.model.resource.Resource
import kotlinx.coroutines.flow.Flow

interface INewsService {
    suspend fun getNews(): Flow<Resource<RecoverResponse>>
}