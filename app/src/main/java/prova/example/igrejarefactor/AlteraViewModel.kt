package prova.example.igrejarefactor

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.launch
import prova.example.igrejarefactor.igreja.AppDataBase


class AlteraViewModel(application: Application, id:Long): AndroidViewModel(application) {
var igreja= MutableLiveData<Igreja>()

    private var _eventAltera = MutableLiveData<Boolean>(false)
    val eventAltera:LiveData<Boolean>
        get()=_eventAltera

    private val db: AppDataBase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            AppDataBase::class.java,
            "pessoas.sqlite")
            .build()
    }


    init {

        viewModelScope.launch{
    igreja.value= db.igrejaDao().buscarPorId(id)
    }
    }



    fun alteraIgreja(){

        viewModelScope.launch{
        db.igrejaDao().editar(igreja.value!!)
    }
        _eventAltera.value = true
    }




    class AlteraViewModelFactory(val application: Application,val id: Long):ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlteraViewModel::class.java)) {
                return AlteraViewModel(application, id) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    fun resetGatilho(){
        _eventAltera.value=false
    }


}