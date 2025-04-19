package com.example.animalthread.ui.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.animalthread.databinding.FragmentLibraryBinding

class LibraryFragment: Fragment() {

    private lateinit var binding: FragmentLibraryBinding
    private val viewModel: LibraryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLibraryBinding.inflate(inflater, container, false)


        viewModel.catImage.observe(viewLifecycleOwner, Observer { url ->
            if (url != null){
                Glide.with(this).load(url).into(binding.image)
            }
        })

        binding.button.setOnClickListener {
            viewModel.getRandomImage()
        }
        return binding.root
    }
}