package uz.otamurod.domain.api.repository

import kotlinx.coroutines.flow.Flow
import uz.otamurod.domain.api.model.Booking
import uz.otamurod.domain.api.model.Hotel
import uz.otamurod.domain.api.model.Rooms
import uz.otamurod.domain.util.DataState

interface HotelRepositoryApi {
    suspend fun fetchHotel(): Flow<DataState<Hotel>>

    suspend fun fetchHotelRooms(): Flow<DataState<Rooms>>

    suspend fun fetchBookingInfo(): Flow<DataState<Booking>>
}