package com.example.tugaspertemuan9

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.tugaspertemuan9.databinding.FragmentGetTicketBinding

class GetTicketFragment : Fragment() {
    private lateinit var binding: FragmentGetTicketBinding

    private val jenisTiket = arrayOf(
        "First Class Ticket",
        "Business Class Ticket",
        "Economy Class Ticket"
    )

    var selectedJenisTiket : String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGetTicketBinding.inflate(inflater, container, false)

        with(binding) {
            val adapterJenisTiket = ArrayAdapter(
                requireContext(),
                R.layout.simple_spinner_item,
                jenisTiket
            )

            adapterJenisTiket.setDropDownViewResource(
                com.google.android.material.R.layout.support_simple_spinner_dropdown_item
            )

            getTicketFragmentSpinner.adapter = adapterJenisTiket
        }

        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){

            getTicketFragmentBtn.setOnClickListener {
                val selectedText = getTicketFragmentSpinner.selectedItem.toString()
                findNavController().apply {
                    previousBackStackEntry?.savedStateHandle?.set("jenisTiket", selectedText)
                }.navigateUp()
            }


        }
    }
}