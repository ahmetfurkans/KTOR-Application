package com.galataapplab.boruto_application.domain.repository

import com.galataapplab.boruto_application.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}