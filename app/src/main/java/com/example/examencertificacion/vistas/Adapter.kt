package com.example.examencertificacion.vistas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examencertificacion.R
import com.example.examencertificacion.databinding.RecyclerModelBinding
import com.example.examencertificacion.modelos.local.entidades.ShoesEntity

//el daptador donde le entregamos la lista y la funcion de estructura
class Adapter : RecyclerView.Adapter<Adapter.ShoesViewHolder>() {

    private var listShoes = listOf<ShoesEntity>()
    private val SelectedShoes = MutableLiveData<ShoesEntity>()



    fun update(list:List<ShoesEntity>){
        listShoes= list
        notifyDataSetChanged()
    }


    // FUNCION PARA SELECCIONAR

    fun selectedShoes():
            LiveData<ShoesEntity> = SelectedShoes


    inner class  ShoesViewHolder(private val mBinding:  RecyclerModelBinding):
        RecyclerView.ViewHolder(mBinding.root), View.OnClickListener{

        fun bind(item: ShoesEntity){
            mBinding.textNombreList.text=item.nombre
            mBinding.textMarcaList.text=item.marca
            mBinding.textNumeroList.text="Talla "+item.numero.toString()
            Glide.with(itemView)
                .load(item.imagenLink)
                .into(mBinding.imageViewList)
            itemView.setOnClickListener(this)

        }
        override  fun onClick(v: View){

            SelectedShoes.value= listShoes[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesViewHolder {
        return ShoesViewHolder(RecyclerModelBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(holder: ShoesViewHolder, position: Int) {
        val shoes = listShoes[position]
        holder.bind(shoes)
    }


    override fun getItemCount()=
        listShoes.size
}