package uz.otamurod.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.otamurod.domain.model.Booking
import uz.otamurod.domain.model.Hotel
import uz.otamurod.domain.model.HotelResponse
import uz.otamurod.domain.model.Rooms

interface HotelRepository {
    suspend fun fetchHotel(): Flow<HotelResponse<Hotel>>

    suspend fun fetchHotelRooms(): Flow<HotelResponse<Rooms>>

    suspend fun fetchBookingInfo(): Flow<HotelResponse<Booking>>
}