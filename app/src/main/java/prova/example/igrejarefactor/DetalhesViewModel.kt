package prova.example.igrejarefactor

import androidx.lifecycle.*
import kotlinx.coroutines.launch



class DetalhesViewModel (val repository: IgrejaRepository,val id: Long):ViewModel() {
    var _igreja= MutableLiveData<Igreja>()
    val igreja : LiveData<Igreja>
    get()= _igreja

    init{
buscaIgreja()
    }


    fun buscaIgreja() {
        viewModelScope.launch {
            _igreja.value = repository.buscarPorID(id)
        }
    }
    class detalheFactory(val repository: IgrejaRepository, val id:Long) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetalhesViewModel::class.java)) {
                return DetalhesViewModel(repository, id) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


}
