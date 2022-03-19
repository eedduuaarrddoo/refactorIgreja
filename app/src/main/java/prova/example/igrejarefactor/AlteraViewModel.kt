package prova.example.igrejarefactor

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.launch
import prova.example.igrejarefactor.igreja.IgrejaDB

class AlteraViewModel(application: Application, id:Long): AndroidViewModel(application) {

    private val db: IgrejaDB by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            IgrejaDB::class.java,
            "pessoas.sqlite")
            .build()
    }

    lateinit var igreja : LiveData<Igreja>
    private var _eventAltera = MutableLiveData<Boolean>(false)
   val eventAltera:LiveData<Boolean>
   get()=_eventAltera
    init {
        viewModelScope.launch{
    igreja = db.igrejaDao().buscarPorId(id )
    }}



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