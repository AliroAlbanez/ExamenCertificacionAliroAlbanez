package com.example.examencertificacion.modelos.remoto

import com.example.examencertificacion.modelos.remoto.clasesApi.DetailClass
import com.example.examencertificacion.modelos.remoto.clasesApi.ShoesClass
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ShoesApi {
    // listado de zapatos
    @GET("shoes")
    suspend fun fecthShoesList(): Response<List<ShoesClass>>


    // seleccionar detalle zapato

    @GET("shoes/{id}")
    suspend fun fechShoesDetail(@Path("id")id:Int): Response<DetailClass>


}