package prova.example.igrejarefactor

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.launch
import prova.example.igrejarefactor.igreja.AppDataBase


class AlteraViewModel(val repository: IgrejaRepository,val id: Long):ViewModel () {
 private var _igreja= MutableLiveData<Igreja>()
    val igreja:LiveData<Igreja>
    get()=_igreja

    private var _eventAltera = MutableLiveData<Boolean>(false)
    val eventAltera:LiveData<Boolean>
        get()=_eventAltera


    init {
buscarIgreja()

    }
fun buscarIgreja(){
    viewModelScope.launch{
        _igreja.value= repository.buscarPorID(id)
    }
}


    fun alteraIgreja(){

        viewModelScope.launch{
        repository.editar(igreja.value!!)
    }
        _eventAltera.value = true
    }




    class AlteraFactory(val repository: IgrejaRepository,val id: Long):ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlteraViewModel::class.java)) {
                return AlteraViewModel(repository , id) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    fun resetGatilho(){
        _eventAltera.value=false
    }


}