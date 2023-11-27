package com.galataapplab.boruto_application.data.repository

import com.galataapplab.boruto_application.data.local.BorutoDatabase
import com.galataapplab.boruto_application.domain.model.Hero
import com.galataapplab.boruto_application.domain.repository.LocalDataSource

class LocalDataSourceImpl(borutoDatabase: BorutoDatabase): LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}