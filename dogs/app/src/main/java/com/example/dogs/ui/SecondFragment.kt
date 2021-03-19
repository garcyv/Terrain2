package com.example.dogs.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dogs.R
import com.example.dogs.databinding.FragmentSecondBinding
import com.example.dogs.ui.adapter.ImagesAdapter
import com.example.dogs.viewModel.DogViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val viewModel : DogViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ImagesAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(context ,2 )

        viewModel.getImages().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })

        adapter.selectedImage().observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it.fav) {
                    it.fav = false
                    viewModel.updateFav(it)
                    Toast.makeText(context, "Ya no es fav", Toast.LENGTH_LONG).show()
                } else {
                    it.fav = true
                    viewModel.updateFav(it)
                    Toast.makeText(context, "Es fav", Toast.LENGTH_LONG).show()
                }
            }
        })

    }
}