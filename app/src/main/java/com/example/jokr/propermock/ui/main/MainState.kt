package com.example.jokr.propermock.ui.main

import com.example.jokr.propermock.models.Race
import com.example.jokr.propermock.models.Races

data class MainState(
    val races: Races
)

sealed class MainEvent {
    class NavigateToDetails(val race: Race) : MainEvent()
}