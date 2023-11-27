package com.galataapplab.boruto_application.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.galataapplab.boruto_application.data.local.dao.HeroDao
import com.galataapplab.boruto_application.data.local.dao.HeroRemoteKeysDao
import com.galataapplab.boruto_application.domain.model.Hero
import com.galataapplab.boruto_application.domain.model.HeroRemoteKeys

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 3)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao

}