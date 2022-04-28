package prova.example.igrejarefactor

import retrofit2.http.GET

interface Api {
    @GET ("igreja/")
        suspend fun getPost(): Post
}