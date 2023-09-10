package uz.otamurod.data.remote

import retrofit2.Retrofit
import uz.otamurod.data.services.ApiService
import uz.otamurod.domain.model.Booking
import uz.otamurod.domain.model.Hotel
import uz.otamurod.domain.model.HotelResponse
import uz.otamurod.domain.model.Rooms
import javax.inject.Inject

class HotelRemoteDataSource @Inject constructor(
    private val apiService: ApiService, retrofit: Retrofit
) : BaseRemoteDataSource(retrofit) {

    suspend fun fetchHotel(): HotelResponse<Hotel> {
        return getResponse(
            request = { apiService.getHotel() },
            defaultErrorMessage = "Error fetching Hotel"
        )
    }

    suspend fun fetchHotelRooms(): HotelResponse<Rooms> {
        return getResponse(
            request = { apiService.getHotelRooms() },
            defaultErrorMessage = "Error fetching hotel rooms"
        )
    }

    suspend fun fetchBookingInfo(): HotelResponse<Booking> {
        return getResponse(
            request = { apiService.getBookingInfo() },
            defaultErrorMessage = "Error fetching room booking"
        )
    }

}