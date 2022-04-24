package prova.example.igrejarefactor

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.launch
import prova.example.igrejarefactor.igreja.AppDataBase


class CadastroViewModel(var repository: IgrejaRepository): ViewModel() {
   var igreja = Igreja()
    private var _eventCadastra = MutableLiveData<Boolean>(false)
    val eventCadastra: LiveData<Boolean>
        get()=_eventCadastra




    fun cadastraIgreja(){
    viewModelScope.launch {
        repository.cadastro(igreja)
        _eventCadastra.value=true
    }

}
    fun resetGatilho(){
        _eventCadastra.value=false
    }
    class CadastraFactory(val repository: IgrejaRepository):ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CadastroViewModel::class.java)) {
                return CadastroViewModel(repository ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


}