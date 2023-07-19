package com.example.examencertificacion.modelos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.examencertificacion.modelos.local.ShoesDAO
import com.example.examencertificacion.modelos.local.entidades.DetailEntity
import com.example.examencertificacion.modelos.remoto.RetrofitClient

class ShoesRepository (private val shoesDao: ShoesDAO) {

    private val networkService = RetrofitClient.retrofitInstance()
    val shoesListLiveData = shoesDao.getAllShoes()
    val shoesDetailLiveData = MutableLiveData<DetailEntity>()


    suspend fun  fechShoes(){

        val service = kotlin.runCatching { networkService.fecthShoesList()}

        service.onSuccess {
            when(it.code()){
                in 200..299-> it.body()?.let {
                    shoesDao.insertAllShoes(fromInternetToShoesEntity(it))
                }
                else -> Log.d("Repo", "${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("Error","${it.message}")
            }
        }
    }

    suspend fun fetchShoesDetail(id: Int): DetailEntity? {
        val service = kotlin.runCatching { networkService.fechShoesDetail(id) }
        return service.getOrNull()?.body()?.let { shoesDetail ->
            val shoesDetailEntity = fromInternetToDetailEntity(shoesDetail)
            shoesDao.insertShoesDetail(shoesDetailEntity)
            shoesDetailEntity
        }
    }
}