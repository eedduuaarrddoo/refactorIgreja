package prova.example.igrejarefactor

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import prova.example.igrejarefactor.Igreja

@Dao
interface IgrejaDao {
    @Insert
    suspend fun cadastrar(i: Igreja)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRemote(estado: List<Igreja>)
    @Update
    suspend fun editar(i: Igreja)
    @Delete
    suspend fun excluir(i: Igreja)
    @Query("SELECT * from Igreja")
    fun buscarTodos(): Flow<List<Igreja>>
    @Query("SELECT * from igreja where id=:id")
  suspend fun buscarPorId(id:Long):Igreja
    @Query("DELETE FROM Igreja")
    fun excluirTodos()

}