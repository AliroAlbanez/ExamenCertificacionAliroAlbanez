package com.example.examencertificacion.modelos.remoto.clasesApi

import com.google.gson.annotations.SerializedName

data class ShoesClass(
    @SerializedName("id") val id:Int,
    @SerializedName("nombre") val nombre:String,
    @SerializedName("origen") val origen:String,
    @SerializedName("imagenLink") val imagenLink:String,
    @SerializedName("marca") val marca:String,
    @SerializedName("numero") val numero:Int
)
