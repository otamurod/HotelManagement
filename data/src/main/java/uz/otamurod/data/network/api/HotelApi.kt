package uz.otamurod.data.network.api


import retrofit2.Response
import retrofit2.http.GET
import uz.otamurod.data.network.api.entities.BookingResponse
import uz.otamurod.data.network.api.entities.HotelResponse
import uz.otamurod.data.network.api.entities.RoomsResponse

/**
 * Retrofit API Service
 */

interface HotelApi {

    @GET("/v3/35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotel(): Response<HotelResponse>

    @GET("/v3/f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getHotelRooms(): Response<RoomsResponse>

    @GET("/v3/e8868481-743f-4eb2-a0d7-2bc4012275c8")
    suspend fun getBookingInfo(): Response<BookingResponse>
}