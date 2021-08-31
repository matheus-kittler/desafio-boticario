package kittler.matheus.test.network.service.backend

import kittler.matheus.test.model.RecoverResponse
import kittler.matheus.test.model.resource.NetworkBoundResource
import kittler.matheus.test.model.resource.Resource
import kittler.matheus.test.network.service.INewsAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class NewsService(
    private val service: INewsAPI
) : INewsService {
    override suspend fun getNews(): Flow<Resource<RecoverResponse>> {
        return flow {
            NetworkBoundResource(
                collector = this,
                call = service.getNewsAsync()
            ) {
                it
            }.build()
        }
    }
}