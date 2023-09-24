package uz.otamurod.domain.usecase

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import uz.otamurod.domain.model.Booking
import uz.otamurod.domain.model.Hotel
import uz.otamurod.domain.model.HotelResponse
import uz.otamurod.domain.model.Rooms

interface HotelUseCase {
    /**
     * UseCase Method to fetch the Hotel from Data Layer
     */
    suspend fun getHotel(): Flow<HotelResponse<Hotel>>

    suspend fun getHotelRooms(): Flow<HotelResponse<Rooms>>

    suspend fun getBookingInfo(): Flow<HotelResponse<Booking>>

}