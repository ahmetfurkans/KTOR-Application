package com.galataapplab.boruto_application.domain.use_cases.get_selected_hero

import com.galataapplab.boruto_application.data.repository.Repository
import com.galataapplab.boruto_application.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}