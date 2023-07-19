package com.example.examencertificacion.vistas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.examencertificacion.R
import com.example.examencertificacion.databinding.FragmentItemBinding
import com.example.examencertificacion.vistas.viewModel.ShoesViewModel


class ItemFragment : Fragment() {

    private  val listViewModel : ShoesViewModel by activityViewModels()
    private lateinit var itemBinding: FragmentItemBinding
    private  var id:Int=0
    private var name=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        itemBinding= FragmentItemBinding.inflate(inflater,container,false)

        arguments?.let { bundle ->

            id = bundle.getInt("id")

        }

        id?.let { id ->
            listViewModel.getDetailByID(id)
        }

        listViewModel.getShoesDetail().observe(viewLifecycleOwner, Observer {


            name = it.nombre

            Glide.with(itemBinding.imageViewObject).load(it.imagenLink)
                .into(itemBinding.imageViewObject)
            itemBinding.textNombre.text = it.nombre
            itemBinding.textMarca.text = it.marca
            itemBinding.textNumero.text = "Talla " + it.numero.toString()
            itemBinding.textOrigen.text = it.origen
            itemBinding.textPrecio.text = "Valor $" + it.precio
            if (it.entrega) {
                itemBinding.textEntrega.text = "Entrega disponible"
            } else {
                itemBinding.textEntrega.text = "Entrega no disponible"
            }





            itemBinding.botonConsultar.setOnClickListener {view->
                val mintent= Intent(Intent.ACTION_SEND)
                mintent.data= Uri.parse("mailto")
                mintent.type="text/plain"

                mintent.putExtra(Intent.EXTRA_EMAIL, arrayOf("consultas@ventazapatos.cl"))
                mintent.putExtra(
                    Intent.EXTRA_SUBJECT,
                    "Solicito información sobre este zapato"+ name
                )


                mintent.putExtra(

                    Intent.EXTRA_TEXT,"Hola\n"+

                            "Quisiera pedir información sobre este calzado " + name + " ,\n" +
                            "Gracias."



                )
                try {
                    startActivity(mintent)
                } catch (e: Exception) {

                    Toast.makeText(context,e.message,Toast.LENGTH_LONG).show()
                }

            }

        })
            return itemBinding.root

    }
}