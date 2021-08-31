package kittler.matheus.test.flow.home

import androidx.lifecycle.*
import kittler.matheus.test.model.User
import kittler.matheus.test.model.resource.Resource
import kittler.matheus.test.network.service.mock.IHomeRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: IHomeRepository
) : ViewModel() {

    private val postsResource = MutableLiveData<Resource<List<User>>>()
    val posts: LiveData<List<User>> = Transformations.map(postsResource) {
        it?.data
    }

    fun getPosts() {
        viewModelScope.launch {
            repository.getPosts().collect {
                postsResource.postValue(it)
            }
        }
    }
}