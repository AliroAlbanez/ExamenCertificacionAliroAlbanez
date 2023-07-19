package com.example.examencertificacion.modelos.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examencertificacion.modelos.local.ShoesDAO
import com.example.examencertificacion.modelos.local.entidades.DetailEntity
import com.example.examencertificacion.modelos.local.entidades.ShoesEntity

@Database(entities = [ShoesEntity::class, DetailEntity::class], version = 1,
    exportSchema = false)
abstract class ShoesDB : RoomDatabase(){

    abstract fun getShoesDao() : ShoesDAO

    companion object{

        @Volatile
        private var
                INSTANCE : ShoesDB? = null
        fun getDataBase(context: Context) : ShoesDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShoesDB::class.java, "shoes_db")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}