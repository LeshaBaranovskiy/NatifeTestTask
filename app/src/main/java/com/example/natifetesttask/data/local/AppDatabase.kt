package com.example.natifetesttask.data.local

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.natifetesttask.BuildConfig.PREVIUOS_VERSION_DB
import com.example.natifetesttask.BuildConfig.VERSION_DB
import com.example.natifetesttask.data.local.dao.BlackListDao
import com.example.natifetesttask.data.local.dao.LastQueriesDao
import com.example.natifetesttask.data.local.dbentity.DBBlackListEntity
import com.example.natifetesttask.data.local.dbentity.DBLastQueriesEntity

@Database(
    entities = [
        DBBlackListEntity::class,
        DBLastQueriesEntity::class
    ],
    version = VERSION_DB,
    autoMigrations = [AutoMigration(from = PREVIUOS_VERSION_DB, to = VERSION_DB)],
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getBlackListDao(): BlackListDao

    abstract fun getLastQueriesDao() : LastQueriesDao

    companion object {
        private var db_instance: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase {
            if (db_instance != null) return db_instance!!

            synchronized(this) {
                db_instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "main_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                return db_instance!!
            }
        }
    }
}