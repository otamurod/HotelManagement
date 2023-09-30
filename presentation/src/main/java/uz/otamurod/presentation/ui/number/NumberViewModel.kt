package uz.otamurod.presentation.ui.number

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.otamurod.domain.model.Rooms
import uz.otamurod.domain.interactor.HotelInteractorApi
import uz.otamurod.domain.util.DataState
import javax.inject.Inject

@HiltViewModel
class NumberViewModel @Inject constructor(
    private val hotelUseCase: HotelInteractorApi
) : ViewModel() {
    private val _rooms = MutableLiveData<DataState<Rooms>>()
    val rooms: LiveData<DataState<Rooms>> = _rooms

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