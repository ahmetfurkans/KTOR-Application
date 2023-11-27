package com.galataapplab.boruto_application.di

import android.content.Context
import com.galataapplab.boruto_application.data.paging_source.SearchHeroesSource
import com.galataapplab.boruto_application.data.repository.DataStoreOperationsImpl
import com.galataapplab.boruto_application.data.repository.Repository
import com.galataapplab.boruto_application.domain.repository.DataStoreOperations
import com.galataapplab.boruto_application.domain.use_cases.UseCases
import com.galataapplab.boruto_application.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.galataapplab.boruto_application.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.galataapplab.boruto_application.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.galataapplab.boruto_application.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.galataapplab.boruto_application.domain.use_cases.search_heroes.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository)
        )
    }
}