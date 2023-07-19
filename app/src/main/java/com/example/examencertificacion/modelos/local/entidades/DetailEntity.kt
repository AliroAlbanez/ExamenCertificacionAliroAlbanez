package com.example.examencertificacion.modelos.local.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shoes_details_table")
data class DetailEntity(

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
    val numero:Int,
    @ColumnInfo(name = "precio")
    val precio: Int,
    @ColumnInfo(name = "entrega")
    val entrega: Boolean

)