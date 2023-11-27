package com.galataapplab.boruto_application.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.galataapplab.boruto_application.data.repository.Repository
import com.galataapplab.boruto_application.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }
}