package com.galataapplab.boruto_application.data.repository

import androidx.paging.PagingData
import com.galataapplab.boruto_application.domain.model.Hero
import com.galataapplab.boruto_application.domain.repository.DataStoreOperations
import com.galataapplab.boruto_application.domain.repository.LocalDataSource
import com.galataapplab.boruto_application.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local: LocalDataSource,
    private val dataStore: DataStoreOperations,
    private val remote: RemoteDataSource,
) {
    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    suspend fun getSelectedHero(heroId: Int): Hero {
        return local.getSelectedHero(heroId = heroId)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return remote.searchHeroes(query = query)
    }

}