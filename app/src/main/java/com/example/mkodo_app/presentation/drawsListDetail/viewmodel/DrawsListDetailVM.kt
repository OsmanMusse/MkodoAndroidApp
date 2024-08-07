package com.example.mkodo_app.presentation.drawsListDetail.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mkodo_app.data.repo.DrawRepository
import com.example.mkodo_app.domain.DrawModelClass
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrawsListDetailVM @Inject constructor(
    private val repo: DrawRepository,
    @ApplicationContext val context: Context
): ViewModel() {


    val drawListResult: LiveData<List<DrawModelClass>>
        get() = _drawListResult

    private val _drawListResult = MutableLiveData<List<DrawModelClass>>()

    init {
        viewModelScope.launch { fetchDraws() }
    }

    fun fetchData(){
        viewModelScope.launch {
            delay(500)
            _drawListResult.value = listOf(DrawModelClass("","",1,2,3,4,5,6,7,121212))
        }
    }

      fun fetchDraws(){
        viewModelScope.launch {
            val result = repo.getDraws(context)
            _drawListResult.value = result

        }
    }
}