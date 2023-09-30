package uz.otamurod.data.interactor

import kotlinx.coroutines.flow.Flow
import uz.otamurod.domain.api.repository.HotelRepositoryApi
import uz.otamurod.domain.interactor.HotelInteractorApi
import uz.otamurod.domain.model.Booking
import uz.otamurod.domain.model.Hotel
import uz.otamurod.domain.model.Rooms
import uz.otamurod.domain.util.DataState
import javax.inject.Inject

class HotelInteractor @Inject constructor(
    private val hotelRepository: HotelRepositoryApi
) : HotelInteractorApi {

    override suspend fun getHotel(): Flow<DataState<Hotel>> {
        return hotelRepository.fetchHotel()
    }

    override suspend fun getHotelRooms(): Flow<DataState<Rooms>> {
        return hotelRepository.fetchHotelRooms()
    }

    override suspend fun getBookingInfo(): Flow<DataState<Booking>> {
        return hotelRepository.fetchBookingInfo()
    }
}