package uz.otamurod.hotelmanagement.ui.hotel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.otamurod.domain.model.Hotel
import uz.otamurod.domain.model.HotelResponse
import uz.otamurod.domain.usecase.HotelUseCase
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(
    private val hotelUseCase: HotelUseCase
) : ViewModel() {
    private val _hotel = MutableLiveData<HotelResponse<Hotel>>()
    val hotel: LiveData<HotelResponse<Hotel>> = _hotel

    init {
        fetchHotel()
    }

    fun fetchHotel() {
        viewModelScope.launch {
            hotelUseCase.getHotel().collect {
                _hotel.value = it
            }
        }
    }
}