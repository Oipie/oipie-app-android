package com.acidtango.search_presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acidtango.core.connectivity.ConnectivityObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    connectivityObserver: ConnectivityObserver
) : ViewModel() {

    var connectivityStatus by mutableStateOf(ConnectivityObserver.Status.Unavailable)
        private set

    init {
        viewModelScope.launch {
            connectivityObserver.observe().collect {
                connectivityStatus = it
            }
        }

        viewModelScope.launch {
            connectivityObserver.checkInternet().collect {
                Log.d("CHECKINTERNET", it.toString())
            }
        }
    }
}
