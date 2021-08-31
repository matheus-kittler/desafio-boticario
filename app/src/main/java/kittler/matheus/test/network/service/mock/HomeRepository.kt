package kittler.matheus.test.network.service.mock

import kittler.matheus.test.model.User
import kittler.matheus.test.model.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepository: IHomeRepository {
    override suspend fun getPosts(): Flow<Resource<List<User>>> {
        return flow {
            val users = listOf(
                User("Carlos",null, "Hoje está um lindo dia, gostaria de sair para praticar exercícios mas com o trabalho acho que terá que ser depois.", "03/02/2020 05:10 PM"),
                User("Lúcia Helena",null, "Todas as terças-feiras o restaurante serve uma carne de panela com um molho muito bom, acompanhando com batatas fritas feitas na casa e um arroz integral de alta qualidade, uma bela refeitção!", "03/02/2020 03:10 PM"),
                User("Thiago",null, "Os livros ultimamente não estão me interessando, gostaria de ver algo novo.", "10/02/2020 12:03 AM"),
                User("Larissa",null, "Em 1625, devido sua posição estratégica na foz do Amazonas os portugueses instalaram um entreposto fiscal comercial denominado Casa de Haver o Peso/Mercado Ver-o-Peso, para arrecadação de tributos dos produtos europeus trazidos para Belém, e dos extraídos da Amazônia", "01/02/2020 02:10 PM"),
                User("Matheus",null, "Olá!", "01/02/2020 10:10 AM"),
            );
            emit(Resource.success(users))
        }
    }
}