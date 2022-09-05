package com.acidtango.home_presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acidtango.home_domain.GetReceiptsUseCase
import com.acidtango.home_domain.Meta
import com.acidtango.home_domain.Receipts
import com.acidtango.home_domain.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    receiptsUseCase: GetReceiptsUseCase
) : ViewModel() {

    var receipts by mutableStateOf(Receipts(items = listOf(), meta = Meta(totalItems = 0)))
        private set

    init {
        viewModelScope.launch {
            when (val result = receiptsUseCase()) {
                is Resource.Error -> {
                    throw RuntimeException("Error, something happened")
                }
                is Resource.Success -> {
                    receipts = result.data!!
                }
            }
        }


    }
}