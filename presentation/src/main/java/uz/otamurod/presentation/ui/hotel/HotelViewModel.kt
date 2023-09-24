package uz.otamurod.presentation.ui.hotel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.otamurod.domain.api.model.Hotel
import uz.otamurod.domain.interactor.HotelInteractorApi
import uz.otamurod.domain.util.DataState
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(
    private val hotelInteractor: HotelInteractorApi
) : ViewModel() {
    private val _hotel = MutableLiveData<DataState<Hotel>>()
    val hotel: LiveData<DataState<Hotel>> = _hotel

    init {
        fetchHotel()
    }

    fun fetchHotel() {
        viewModelScope.launch {
            hotelInteractor.getHotel().collect {
                _hotel.value = it
            }
        }
    }
}