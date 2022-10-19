package ru.spbu.retest

import androidx.compose.runtime.*
import java.util.*
import kotlin.concurrent.schedule
import kotlin.system.exitProcess

const val DELAY_TIME = 100L

class ViewModel {
    var state: State by mutableStateOf(initialState())
        private set

    data class State(
        var progress: Int = 0, var isClicked: Boolean = false
    )

    private fun initialState(): State = State()

    private inline fun updateState(update: State.() -> State) {
        state = state.update()
    }

    private fun increaseProgress() = updateState {
        copy(progress = progress + 1)
    }

    fun doProgress() {
        Timer("SettingUp", false).schedule(DELAY_TIME) {
            increaseProgress()
        }
    }

    fun doOnClick() = updateState {
        copy(isClicked = true)
    }

    fun doOnClickFinish() {
        exitProcess(0)
    }
}
