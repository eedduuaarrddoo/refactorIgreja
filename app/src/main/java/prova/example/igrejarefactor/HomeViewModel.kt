package prova.example.igrejarefactor

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import prova.example.igrejarefactor.igreja.IgrejaDB

class HomeViewModel(application: Application): AndroidViewModel(application) {
    var list: LiveData<List<Igreja>>

    private val db:IgrejaDB by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            IgrejaDB::class.java,
            "pessoas.sqlite")
            .build()
    }


    init {
        list= db.igrejaDao().buscarTodos()
    }
}