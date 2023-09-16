package uz.otamurod.hotelmanagement.ui.booking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.otamurod.domain.model.Booking
import uz.otamurod.domain.model.HotelResponse
import uz.otamurod.domain.usecase.HotelUseCase
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    private val hotelUseCase: uz.otamurod.domain.usecase.HotelUseCase
) : ViewModel() {
    private val _bookRoom = MutableLiveData<uz.otamurod.domain.model.HotelResponse<uz.otamurod.domain.model.Booking>>()
    val bookRoom: LiveData<uz.otamurod.domain.model.HotelResponse<uz.otamurod.domain.model.Booking>> = _bookRoom

    init {
        fetchBookingInfo()
    }

    fun fetchBookingInfo() {
        viewModelScope.launch {
            hotelUseCase.getBookingInfo().collect {
                _bookRoom.value = it
            }
        }
    }
}