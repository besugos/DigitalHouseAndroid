package com.besugos.aula35ex1.listagem.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.besugos.aula35ex1.listagem.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers

class CategoryViewModel (
    private val _repository: CategoryRepository
): ViewModel() {

    private var _categories: List<String> = listOf()

    fun obterLista() = liveData(Dispatchers.IO) {
        // Obtem dados da API
        val response = _repository.obterLista()

        _categories = response

        emit(response)
    }

    class CategoryViewModelFactory(
        private val repository: CategoryRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CategoryViewModel(repository) as T
        }
    }
}
