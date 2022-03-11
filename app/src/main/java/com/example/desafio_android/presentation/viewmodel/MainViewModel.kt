package com.example.desafio_android.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafio_android.data.local.repository.ReposLocalRepository
import com.example.desafio_android.domain.model.RepoModel
import com.example.desafio_android.domain.model.UserModel
import com.example.desafio_android.domain.usecase.GetReposUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class MainViewModel(
    private val useCase: GetReposUseCase,
    private val itemsLocalRepo: ReposLocalRepository
) : ViewModel() {

    private val _listRepos: MutableLiveData<List<RepoModel>> = MutableLiveData()
    val listRepos: LiveData<List<RepoModel>> = _listRepos

    fun getRepos() {
        viewModelScope.launch(Dispatchers.IO) {
            with(useCase()) {
                _listRepos.postValue(this)
                itemsLocalRepo.createItemsInDatabase(this)
            }
        }
    }
}