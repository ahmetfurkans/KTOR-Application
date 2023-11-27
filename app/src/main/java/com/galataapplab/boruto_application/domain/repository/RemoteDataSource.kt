package com.galataapplab.boruto_application.domain.repository

import androidx.paging.PagingData
import com.galataapplab.boruto_application.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(query: String): Flow<PagingData<Hero>>
}