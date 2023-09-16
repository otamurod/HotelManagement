package uz.otamurod.presentation.ui.number

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.otamurod.domain.model.HotelResponse
import uz.otamurod.domain.model.Rooms
import uz.otamurod.domain.usecase.HotelUseCase
import javax.inject.Inject

@HiltViewModel
class NumberViewModel @Inject constructor(
    private val hotelUseCase: HotelUseCase
) : ViewModel() {
    private val _rooms = MutableLiveData<HotelResponse<Rooms>>()
    val rooms: LiveData<HotelResponse<Rooms>> = _rooms

    init {
        fetchHotelRooms()
    }

    fun fetchHotelRooms() {
        viewModelScope.launch {
            hotelUseCase.getHotelRooms().collect {
                _rooms.value = it
            }
        }
    }
}