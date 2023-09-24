package uz.otamurod.data.remote.datasource

import retrofit2.Response
import retrofit2.Retrofit
import uz.otamurod.data.mapper.toDto
import uz.otamurod.data.network.api.HotelApi
import uz.otamurod.domain.api.model.Booking
import uz.otamurod.domain.api.model.Hotel
import uz.otamurod.domain.api.model.Rooms
import uz.otamurod.domain.util.DataState
import javax.inject.Inject

class HotelRemoteDataSource @Inject constructor(
    private val hotelApi: HotelApi, retrofit: Retrofit
) : BaseRemoteDataSource(retrofit) {

    suspend fun fetchHotel(): DataState<Hotel> {
        val hotelResponse = hotelApi.getHotel()
        val hotelDto = hotelResponse.body()?.toDto()

        return getResponse(
            request = { Response.success(hotelDto) },
            defaultErrorMessage = "Error fetching Hotel"
        )
    }

    suspend fun fetchHotelRooms(): DataState<Rooms> {
        val roomsResponse = hotelApi.getHotelRooms()
        val roomsDto = roomsResponse.body()?.toDto()

        return getResponse(
            request = { Response.success(roomsDto) },
            defaultErrorMessage = "Error fetching hotel rooms"
        )
    }

    suspend fun fetchBookingInfo(): DataState<Booking> {
        val bookingResponse = hotelApi.getBookingInfo()
        val bookingDto = bookingResponse.body()?.toDto()
        return getResponse(
            request = { Response.success(bookingDto) },
            defaultErrorMessage = "Error fetching room booking"
        )
    }

}