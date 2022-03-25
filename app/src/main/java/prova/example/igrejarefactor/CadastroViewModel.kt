package prova.example.igrejarefactor

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch
import prova.example.igrejarefactor.igreja.AppDataBase


class CadastroViewModel(application: Application): AndroidViewModel(application) {
   var igreja = Igreja()
    private var _eventCadastra = MutableLiveData<Boolean>(false)
    val eventCadastra: LiveData<Boolean>
        get()=_eventCadastra


    private val db: AppDataBase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            AppDataBase::class.java,
            "igreja.sqlite")
            .build()
    }

    fun cadastraIgreja(){
    viewModelScope.launch {
        db.igrejaDao().cadastrar(igreja)
    }
        _eventCadastra.value=true
}
    fun resetGatilho(){
        _eventCadastra.value=false
    }

}