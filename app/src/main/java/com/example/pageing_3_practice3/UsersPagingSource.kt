package com.example.pageing_3_practice3

import androidx.paging.PagingSource
import androidx.paging.PagingState

class UsersPagingSource (
    private val apiService: APIService
    ) : PagingSource<Int, Results>()
    {

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {
            return try {
                val page = params.key ?: 1
                val response = apiService.getCharacter(page)

                LoadResult.Page(
                    data = response.results,
                    prevKey = if (response.info.prev == null) null else page - 1,
                    nextKey = if (response.info.next != null) page + 1 else null
                )
            } catch (e: Exception) {
                e.printStackTrace()
                LoadResult.Error(e)
            }
        }

        override fun getRefreshKey(state: PagingState<Int, Results>): Int? {
            return state.anchorPosition?.let { anchorPosition ->
                state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                    ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
            }
        }
    }
