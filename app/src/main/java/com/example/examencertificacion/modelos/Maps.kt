package com.example.examencertificacion.modelos

import com.example.examencertificacion.modelos.local.entidades.DetailEntity
import com.example.examencertificacion.modelos.local.entidades.ShoesEntity
import com.example.examencertificacion.modelos.remoto.clasesApi.DetailClass
import com.example.examencertificacion.modelos.remoto.clasesApi.ShoesClass

fun fromInternetToShoesEntity(shoesList: List<ShoesClass>): List<ShoesEntity>{

    return shoesList.map {

        ShoesEntity(
            id= it.id,
            nombre = it.nombre,
            origen = it.origen,
            imagenLink = it.imagenLink,
            marca = it.marca,
            numero = it.numero

        )


    }

}

fun fromInternetToDetailEntity(detail: DetailClass): DetailEntity{

    return DetailEntity(
        id= detail.id,
        nombre = detail.nombre,
        origen = detail.origen,
        imagenLink = detail.imagenLink,
        marca = detail.marca,
        numero = detail.numero,
        precio  = detail.precio,
        entrega = detail.entrega

    )


}