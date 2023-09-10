package uz.otamurod.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.otamurod.domain.model.Booking
import uz.otamurod.domain.model.Hotel
import uz.otamurod.domain.model.HotelResponse
import uz.otamurod.domain.model.Rooms
import uz.otamurod.domain.repository.HotelRepository
import javax.inject.Inject

internal class HotelUseCaseImpl @Inject constructor(
    private val hotelRepository: HotelRepository
) : HotelUseCase {

    override suspend fun getHotel(): Flow<HotelResponse<Hotel>> {
        return hotelRepository.fetchHotel()
    }

    override suspend fun getHotelRooms(): Flow<HotelResponse<Rooms>> {
        return hotelRepository.fetchHotelRooms()
    }

    override suspend fun getBookingInfo(): Flow<HotelResponse<Booking>> {
        return hotelRepository.fetchBookingInfo()
    }
}