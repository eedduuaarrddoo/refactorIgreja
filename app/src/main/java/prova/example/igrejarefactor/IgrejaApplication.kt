package prova.example.igrejarefactor

import android.app.Application
import prova.example.igrejarefactor.igreja.AppDataBase

class IgrejaApplication:Application() {
val database by lazy{AppDataBase.invoke(this)}

val repository by lazy { IgrejaRepository(database.igrejaDao()) }
}