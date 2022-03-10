package prova.example.igrejarefactor

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Igreja (
    var nome: String,
    var descricao: String,
    var nfieis: Int,
    var profeta: String,
    var endereco: String,

){
    @PrimaryKey(autoGenerate = true)
    var id = 0
    constructor() :this ("", "", 0, "", "")
}

