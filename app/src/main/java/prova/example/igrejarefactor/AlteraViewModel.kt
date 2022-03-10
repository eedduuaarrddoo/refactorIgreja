package prova.example.igrejarefactor

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch
import prova.example.igrejarefactor.igreja.IgrejaDB

class AlteraViewModel(application: Application): AndroidViewModel(application) {

    private val db: IgrejaDB by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            IgrejaDB::class.java,
            "pessoas.sqlite")
            .build()
    }

    lateinit var igreja : LiveData<Igreja>

    init {
        viewModelScope.launch{
    igreja = db.igrejaDao().buscarPorId(1)
    }}
    fun alteraPessoa(){
        viewModelScope.launch{
        db.igrejaDao().editar(igreja.value!!)
    }}
}