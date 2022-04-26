package prova.example.igrejarefactor

import retrofit2.http.GET

interface Api {
    @GET //caminhoApi
        suspend fun getPost(): Post
}