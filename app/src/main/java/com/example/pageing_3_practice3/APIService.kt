package com.example.pageing_3_practice3

import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

@GET("character")
suspend fun getCharacter(
    @Query("page")page : Int
): Users
}