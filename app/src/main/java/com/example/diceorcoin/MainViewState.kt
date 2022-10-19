package com.example.diceorcoin

sealed class MainViewState{
    object Coin: MainViewState()
    object Dice: MainViewState()
}
