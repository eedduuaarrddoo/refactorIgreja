package prova.example.igrejarefactor

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch
import prova.example.igrejarefactor.igreja.IgrejaDB

class DetalhesViewModel (application: Application): AndroidViewModel(application){
    lateinit var igreja : LiveData<Igreja>




    private val db: IgrejaDB by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            IgrejaDB::class.java,
            "pessoas.sqlite")
            .build()
    }

    init{
    viewModelScope.launch {
        igreja=db.igrejaDao().buscarPorId(3)
    }
}


}