package com.example.examencertificacion.modelos.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.examencertificacion.modelos.local.entidades.DetailEntity
import com.example.examencertificacion.modelos.local.entidades.ShoesEntity

@Dao
interface ShoesDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllShoes(listShoes: List<ShoesEntity>)


    @Query("SELECT * FROM shoes_table  ORDER BY id ASC")
    fun getAllShoes(): LiveData<List<ShoesEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoesDetail(course: DetailEntity)


    @Query("SELECT * FROM shoes_details_table  WHERE id=:id")
    fun  getShoesDetail(id:String): LiveData<DetailEntity?>

}