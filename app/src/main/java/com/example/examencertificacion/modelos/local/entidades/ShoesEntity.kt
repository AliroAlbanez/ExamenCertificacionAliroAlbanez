package com.example.examencertificacion.modelos.local.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shoes_table")
data class ShoesEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id:Int,
    @ColumnInfo(name = "nombre")
    val nombre:String,
    @ColumnInfo(name = "origen")
    val origen:String,
    @ColumnInfo(name = "imagenLink")
    val imagenLink:String,
    @ColumnInfo(name = "marca")
    val marca:String,
    @ColumnInfo(name = "numero")
    val numero:Int
)