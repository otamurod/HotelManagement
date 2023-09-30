package uz.otamurod.domain.api.repository

import kotlinx.coroutines.flow.Flow
import uz.otamurod.domain.model.Booking
import uz.otamurod.domain.model.Hotel
import uz.otamurod.domain.model.Rooms
import uz.otamurod.domain.util.DataState

interface HotelRepositoryApi {
    suspend fun fetchHotel(): Flow<DataState<Hotel>>

    suspend fun fetchHotelRooms(): Flow<DataState<Rooms>>

    suspend fun fetchBookingInfo(): Flow<DataState<Booking>>
}