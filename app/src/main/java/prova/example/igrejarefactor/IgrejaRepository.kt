package prova.example.igrejarefactor

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class IgrejaRepository(private val igrejaDao: IgrejaDao) {
    val list:Flow<List<Igreja>> = igrejaDao.buscarTodos()

  suspend fun cadastro(i:Igreja){
        igrejaDao.cadastrar(i)
    }

    suspend fun editar(i: Igreja){
        igrejaDao.editar(i)
    }
    suspend fun buscarPorID(id:Long):Igreja{
        return igrejaDao.buscarPorId(id)
    }



}