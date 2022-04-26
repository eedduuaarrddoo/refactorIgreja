package prova.example.igrejarefactor

import androidx.room.PrimaryKey

data  class Post (var nome: String,
            var descricao: String,
            var nfieis: Int,
            var profeta: String,
            var endereco: String,
            @PrimaryKey(autoGenerate = true) var id: Long = 0,
            ){
}