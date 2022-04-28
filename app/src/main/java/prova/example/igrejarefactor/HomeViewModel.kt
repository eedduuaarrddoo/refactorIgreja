package prova.example.igrejarefactor

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.launch


class HomeViewModel(repository: IgrejaRepository, private val repositoryApi: Repository):ViewModel(){
    val myResponse : MutableLiveData<Post> = MutableLiveData()
    var list: LiveData<List<Igreja>> = repository.list.asLiveData()

    class homeFactory(val repository: IgrejaRepository, val repositoryApi: Repository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(repository,repositoryApi) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
fun getPost(){
    viewModelScope.launch {
        val response:Post = repositoryApi.getPost()
        myResponse.value=response

    }



}



}