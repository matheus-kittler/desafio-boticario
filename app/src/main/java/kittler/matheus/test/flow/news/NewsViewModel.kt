package kittler.matheus.test.flow.news

import androidx.lifecycle.*
import kittler.matheus.test.model.New
import kittler.matheus.test.model.Recover
import kittler.matheus.test.model.RecoverResponse
import kittler.matheus.test.model.resource.Resource
import kittler.matheus.test.model.resource.Status
import kittler.matheus.test.network.service.backend.INewsService
import kittler.matheus.test.dispatcher.IAppDispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NewsViewModel(
    private val service: INewsService,
    private val dispatchers: IAppDispatchers
): ViewModel() {

    private val newsResource = MutableLiveData<New>()

    val news: MutableLiveData<New>
    get() = newsResource

    val recovers: LiveData<List<Recover>> by lazy {
        val recovers = MutableLiveData<List<Recover>>()

        viewModelScope.launch(dispatchers.io) {
            loadNews(recovers)
        }

        return@lazy recovers
    }

    private val isError: MutableLiveData<String> = MutableLiveData()

    val errorMessage: LiveData<String>
        get() = isError

    private suspend fun loadNews(recovers: MutableLiveData<List<Recover>>) {
        service.getNews().collect {
            if (hasObject(it)) {
                recovers.postValue(it.data?.news)
            }

            if (requestFailed(it)) {
                if (it.message != null) {
                    isError.postValue(it.message)
                    recovers.postValue(listOf())
                }
            }
        }
    }

    private fun hasObject(resource: Resource<RecoverResponse>) =
        resource.status == Status.SUCCESS && resource.data?.news != null

    private fun requestFailed(resource: Resource<RecoverResponse?>) =
        resource.status == Status.ERROR

}
