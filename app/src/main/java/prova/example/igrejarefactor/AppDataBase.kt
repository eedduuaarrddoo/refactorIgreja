package prova.example.igrejarefactor.igreja

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import prova.example.igrejarefactor.Igreja
import prova.example.igrejarefactor.IgrejaDao


@Database(entities = [Igreja::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun igrejaDao(): IgrejaDao

companion object{
    @Volatile private var instance:AppDataBase? = null
    private val LOCK = Any()

    operator fun invoke(context: Context)=instance?: synchronized(LOCK){
        instance?: buildDatabase(context).also{ instance=it}
    }
    private fun buildDatabase(context: Context)=
        Room.databaseBuilder(context,AppDataBase::class.java,"igreja.sqlite")
            .fallbackToDestructiveMigration()
            .build()


}

}