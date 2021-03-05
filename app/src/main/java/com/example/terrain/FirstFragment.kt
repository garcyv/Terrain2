package com.example.terrain

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.terrain.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: MarsViewModel by activityViewModels()

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
        val adapter = TerrainAdapter()
        binding.rvTerrain.adapter =adapter
        binding.rvTerrain.layoutManager = GridLayoutManager(context,2)


         viewModel.getFetchTerrains().observe(viewLifecycleOwner, Observer {
             it?.let {
                // Log.d("LISTADO",it.toString())
                 adapter.update(it)
             }
         })

        viewModel.getFetchTerrainsWithCoroutines().observe(viewLifecycleOwner, Observer {
            it?.let {
               // Log.d("LISTADO COR",it.toString())
                adapter.update(it)
            }
        })

     /*   view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
           }
           */
}
}
