package prova.example.igrejarefactor.igreja

import androidx.room.Database
import androidx.room.RoomDatabase
import prova.example.igrejarefactor.Igreja
import prova.example.igrejarefactor.IgrejaDao


@Database(entities = [Igreja::class], version = 1)
abstract class IgrejaDB: RoomDatabase() {
    abstract fun igrejaDao(): IgrejaDao

}