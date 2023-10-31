package com.example.tugaspertemuan9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tugaspertemuan9.databinding.FragmentOrderTicketBinding
import com.example.tugaspertemuan9.databinding.FragmentTicketBinding


class OrderTicketFragment : Fragment() {
    private lateinit var binding: FragmentOrderTicketBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderTicketBinding.inflate(inflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){

            orderTicketFragmentEdit.setOnClickListener{
                val action = OrderTicketFragmentDirections.actionOrderTicketFragmentToGetTicketFragment()
                findNavController().navigate(action)
            }

            orderTicketFragmentBtn.setOnClickListener{
                findNavController().navigateUp()
            }

            findNavController().currentBackStackEntry?.savedStateHandle?.let {
                    handle ->
                handle.getLiveData<String>("jenisTiket").observe(viewLifecycleOwner){
                        res->
                    orderTicketFragmentEdit.setText(res)
                }
            }
        }
    }
}