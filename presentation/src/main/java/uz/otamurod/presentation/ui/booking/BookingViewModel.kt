package uz.otamurod.presentation.ui.booking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.otamurod.domain.model.Booking
import uz.otamurod.domain.interactor.HotelInteractorApi
import uz.otamurod.domain.util.DataState
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    private val hotelUseCase: HotelInteractorApi
) : ViewModel() {
    private val _bookRoom = MutableLiveData<DataState<Booking>>()
    val bookRoom: LiveData<DataState<Booking>> = _bookRoom

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