package com.example.examencertificacion.vistas.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.examencertificacion.modelos.ShoesRepository
import com.example.examencertificacion.modelos.local.database.ShoesDB
import com.example.examencertificacion.modelos.local.entidades.DetailEntity
import com.example.examencertificacion.modelos.local.entidades.ShoesEntity
import kotlinx.coroutines.launch

class ShoesViewModel (application: Application): AndroidViewModel(application){

    private val repository : ShoesRepository

    private val shoesDetailLiveData = MutableLiveData<DetailEntity>()

    init{
        val bd= ShoesDB.getDataBase(application)
        val  shoesDao = bd.getShoesDao()

        repository = ShoesRepository(shoesDao)

        viewModelScope.launch {

            repository.fechShoes()
        }
    }

    fun getShoesList(): LiveData<List<ShoesEntity>> = repository.shoesListLiveData


    fun getShoesDetail(): LiveData<DetailEntity> = shoesDetailLiveData



    fun getDetailByID(id:Int) = viewModelScope.launch {

        val courseDetail = repository.fetchShoesDetail(id)
        courseDetail?.let {

            shoesDetailLiveData.postValue(it)
        }
    }


}