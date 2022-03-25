package prova.example.igrejarefactor

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room


class HomeViewModel(repository: IgrejaRepository):ViewModel(){

    var list: LiveData<List<Igreja>> = repository.list.asLiveData()

    class Factory(val repository: IgrejaRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }




}