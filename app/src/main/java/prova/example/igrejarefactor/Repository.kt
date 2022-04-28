package prova.example.igrejarefactor

class Repository {

    suspend fun getPost(): Post{

        return RetrofitInstance.api.getPost()
    }

}