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

    suspend fun fetchHotel(): uz.otamurod.domain.model.HotelResponse<uz.otamurod.domain.model.Hotel> {
        return getResponse(
            request = { apiService.getHotel() },
            defaultErrorMessage = "Error fetching Hotel"
        )
    }

    suspend fun fetchHotelRooms(): uz.otamurod.domain.model.HotelResponse<uz.otamurod.domain.model.Rooms> {
        return getResponse(
            request = { apiService.getHotelRooms() },
            defaultErrorMessage = "Error fetching hotel rooms"
        )
    }

    suspend fun fetchBookingInfo(): uz.otamurod.domain.model.HotelResponse<uz.otamurod.domain.model.Booking> {
        return getResponse(
            request = { apiService.getBookingInfo() },
            defaultErrorMessage = "Error fetching room booking"
        )
    }

}