package app.iitdh

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel()
{
    private val _currentScreen : MutableState<String> = mutableStateOf(Screen.Home.route)

    val currentScreen : MutableState<String> = _currentScreen
}