package com.example.consumobar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.InvalidationTracker
import com.example.consumobar.databinding.FragmentFirstBinding
import com.example.consumobar.model.Consumos
import com.example.consumobar.model.ConsumosAdapter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel : ConsumosViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ConsumosAdapter()
        binding.rvConsumos.adapter = adapter

        binding.rvConsumos.layoutManager = LinearLayoutManager(context)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        val consumo= Consumos(
                1,
                "consumo 1",
                2,
                10,
                20 )

        val consumo2= Consumos(
                1,
                "consumo 2",
                3,
                10,
                30 )

        viewModel.InsertConsumo(consumo)
        viewModel.InsertConsumo(consumo2)

    viewModel.allConsumos.observe(viewLifecycleOwner, Observer {
        adapter.update(it)
    })
    }
}