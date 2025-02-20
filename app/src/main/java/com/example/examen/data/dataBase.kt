package com.example.examen.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Student::class],
    version = 1,
    exportSchema = false
)
abstract class dataBase : RoomDatabase() {


    abstract fun studentDao() : StudentDAO

    companion object {
        @Volatile
        private var INSTANCE: dataBase? = null


        fun getDatabase(context: Context): dataBase{
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }


        private fun buildDatabase(context: Context): dataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                dataBase::class.java,
                "database"
            )//.createFromAsset("database/database.db")
                .build()
        }
    }
}
