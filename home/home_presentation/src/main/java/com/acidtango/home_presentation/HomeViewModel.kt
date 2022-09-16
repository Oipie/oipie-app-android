package com.acidtango.home_presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acidtango.home_domain.ErrorEntity
import com.acidtango.home_domain.GetReceiptsUseCase
import com.acidtango.home_domain.Meta
import com.acidtango.home_domain.Receipts
import com.acidtango.home_domain.Resource
import com.acidtango.home_domain.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    receiptsUseCase: GetReceiptsUseCase
) : ViewModel() {

    var receipts by mutableStateOf(Receipts(items = listOf(), meta = Meta(totalItems = 0)))
        private set

    var errorMessage by mutableStateOf<UiText>(UiText.DynamicString(""))
        private set

    init {
        viewModelScope.launch {
            receiptsUseCase().collect() {
                when (it) {
                    is Resource.Error -> {
                        errorMessage = when (it.error) {
                            is ErrorEntity.ApiError -> {
                                val apiError = ((it.error!!) as ErrorEntity.ApiError)
                                UiText.DynamicString(apiError.code.toString())
                            }
                            is ErrorEntity.UnknownError -> {
                                val unknownError = ((it.error!!) as ErrorEntity.UnknownError)
                                // Register exception into crashAnalytics
                                // show error message
                                unknownError.message
                            }
                            null -> TODO()
                        }
                    }
                    is Resource.Success -> {
                        receipts = it.data!!
                    }
                }
            }
        }
    }
}
