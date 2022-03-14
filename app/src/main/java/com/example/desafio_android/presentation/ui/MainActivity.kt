package com.example.desafio_android.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.desafio_android.databinding.ActivityMainBinding
import com.example.desafio_android.presentation.adapter.ReposAdapter
import com.example.desafio_android.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getRepos()
        setupLoading()
    }

    override fun onResume() {
        super.onResume()

        setupRecycler()
    }

    private fun setupLoading() {
        viewModel.loadingList.observe(this) {
            it.let {
                binding.loadingBar.isVisible = it
            }
        }
    }

    private fun setupRecycler() {
        viewModel.listRepos.observe(this) {
            it?.let {
                binding.recyclerRepos.adapter = ReposAdapter(it)
            }
        }
    }
}