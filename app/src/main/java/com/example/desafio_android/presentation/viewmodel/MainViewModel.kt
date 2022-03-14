package com.example.desafio_android.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafio_android.domain.model.RepoModel
import com.example.desafio_android.domain.usecase.GetReposUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class MainViewModel(
    private val useCase: GetReposUseCase,
) : ViewModel() {

    private val _listRepos: MutableLiveData<List<RepoModel>> = MutableLiveData()
    val listRepos: LiveData<List<RepoModel>> = _listRepos
    private val _loadingList: MutableLiveData<Boolean> = MutableLiveData()
    val loadingList: LiveData<Boolean> = _loadingList

    fun getRepos() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = useCase()
            if (result.isEmpty()) {
                _loadingList.postValue(true)
            } else {
                _listRepos.postValue(result)
                _loadingList.postValue(false)
            }
        }
    }
}