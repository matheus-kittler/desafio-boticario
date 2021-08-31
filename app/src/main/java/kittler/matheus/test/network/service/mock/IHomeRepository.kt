package kittler.matheus.test.network.service.mock


import kittler.matheus.test.model.User
import kittler.matheus.test.model.resource.Resource
import kotlinx.coroutines.flow.Flow

interface IHomeRepository {
    suspend fun getPosts(): Flow<Resource<List<User>>>
}