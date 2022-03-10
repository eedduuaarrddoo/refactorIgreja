package prova.example.igrejarefactor

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch
import prova.example.igrejarefactor.igreja.IgrejaDB

class CadastroViewModel(application: Application): AndroidViewModel(application) {
   var igreja = Igreja()


    private val db: IgrejaDB by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            IgrejaDB::class.java,
            "pessoas.sqlite")
            .build()
    }

    fun cadastraIgreja(){
    viewModelScope.launch {
        db.igrejaDao().cadastrar(igreja)
    }


}


}