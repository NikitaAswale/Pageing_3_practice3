package com.example.pageing_3_practice3

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class UserRepository {

    private val apiService = RetrofitInstance.apiServer

    fun getCharacter(): Flow<PagingData<Results>>{
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                UsersPagingSource(apiService)
            }
        ).flow
    }
}