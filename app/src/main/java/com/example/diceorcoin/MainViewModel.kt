package com.example.diceorcoin

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.diceorcoin.MainViewState

class MainViewModel : ViewModel() {
    private val _containerState = mutableStateOf<MainViewState>(MainViewState.Coin)
    val containerState : State<MainViewState>
        get() = _containerState

    fun switchView(view : MainViewState){
        _containerState.value = view
    }
}