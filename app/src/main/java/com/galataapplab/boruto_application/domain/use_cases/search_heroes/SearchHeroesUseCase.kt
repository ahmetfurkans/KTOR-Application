package com.galataapplab.boruto_application.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.galataapplab.boruto_application.data.repository.Repository
import com.galataapplab.boruto_application.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>> {
        return repository.searchHeroes(query = query)
    }
}