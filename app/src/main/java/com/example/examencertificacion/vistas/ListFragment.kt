package com.example.examencertificacion.vistas

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examencertificacion.R
import com.example.examencertificacion.databinding.FragmentListBinding
import com.example.examencertificacion.modelos.local.entidades.ShoesEntity
import com.example.examencertificacion.vistas.viewModel.ShoesViewModel


class ListFragment : Fragment() {
   lateinit var listBinding: FragmentListBinding
    private val listViewModel : ShoesViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       listBinding= FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val adapter = Adapter()
        listBinding.recyclerView1.adapter= adapter
        listBinding.recyclerView1.layoutManager= GridLayoutManager(context,2)
        listViewModel.getShoesList().observe(viewLifecycleOwner, Observer {

            it?.let {
                adapter.update(it)
            }

        })


        adapter.selectedShoes().observe(viewLifecycleOwner, Observer {


            it?.let {


            }
            val bundle = Bundle().apply {
                putInt("id", it.id)
            }
            findNavController().navigate(R.id.action_listFragment_to_itemFragment, bundle)

        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        //mBinding = null
    }
}