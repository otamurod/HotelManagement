package uz.otamurod.domain.interactor

import kotlinx.coroutines.flow.Flow
import uz.otamurod.domain.model.Booking
import uz.otamurod.domain.model.Hotel
import uz.otamurod.domain.model.Rooms
import uz.otamurod.domain.util.DataState

interface HotelInteractorApi {
    /**
     * UseCase Method to fetch the Hotel from Data Layer
     */
    suspend fun getHotel(): Flow<DataState<Hotel>>

    suspend fun getHotelRooms(): Flow<DataState<Rooms>>

    suspend fun getBookingInfo(): Flow<DataState<Booking>>

}