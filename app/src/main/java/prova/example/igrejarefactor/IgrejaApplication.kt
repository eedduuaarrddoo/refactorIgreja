package prova.example.igrejarefactor

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import prova.example.igrejarefactor.igreja.AppDataBase
@HiltAndroidApp
class IgrejaApplication:Application() {
val database by lazy{AppDataBase.invoke(this)}
val repository by lazy { IgrejaRepository(database.igrejaDao()) }
val repositoryApi by lazy { Repository() }
}