package uz.otamurod.data.remote.datasource

import retrofit2.Response
import retrofit2.Retrofit
import uz.otamurod.data.network.api.HotelApi
import uz.otamurod.data.network.mapper.BookingResponseMapper
import uz.otamurod.data.network.mapper.HotelResponseMapper
import uz.otamurod.data.network.mapper.RoomsResponseMapper
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
        val hotelBo = HotelResponseMapper.Hotel(hotelResponse.body()!!).invoke()

        return getResponse(
            request = { Response.success(hotelBo) },
            defaultErrorMessage = "Error fetching Hotel"
        )
    }

    suspend fun fetchHotelRooms(): DataState<Rooms> {
        val roomsResponse = hotelApi.getHotelRooms()
        val roomsBo = RoomsResponseMapper.Rooms(roomsResponse.body()!!).invoke()

        return getResponse(
            request = { Response.success(roomsBo) },
            defaultErrorMessage = "Error fetching hotel rooms"
        )
    }

    suspend fun fetchBookingInfo(): DataState<Booking> {
        val bookingResponse = hotelApi.getBookingInfo()
        val bookingBo = BookingResponseMapper.Booking(bookingResponse.body()!!).invoke()
        return getResponse(
            request = { Response.success(bookingBo) },
            defaultErrorMessage = "Error fetching room booking"
        )
    }

}