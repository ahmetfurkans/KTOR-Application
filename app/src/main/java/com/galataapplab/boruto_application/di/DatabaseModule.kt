package com.galataapplab.boruto_application.di

import android.content.Context
import androidx.room.Room
import com.galataapplab.boruto_application.data.local.BorutoDatabase
import com.galataapplab.boruto_application.data.repository.LocalDataSourceImpl
import com.galataapplab.boruto_application.domain.repository.LocalDataSource
import com.galataapplab.boruto_application.util.Constants.BORUTO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        BorutoDatabase::class.java,
        BORUTO_DATABASE
    ).build()

    @Provides
    @Singleton
    fun provideLocalDataSource(
        database: BorutoDatabase
    ): LocalDataSource {
        return LocalDataSourceImpl(
            borutoDatabase = database
        )
    }
}