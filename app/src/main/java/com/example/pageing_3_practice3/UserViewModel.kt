package com.example.pageing_3_practice3

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class UserViewModel : ViewModel() {

    private val repository = UserRepository()

    val character : Flow<PagingData<Results>> = repository.getCharacter()
}