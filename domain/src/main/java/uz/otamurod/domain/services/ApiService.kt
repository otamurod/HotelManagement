package uz.otamurod.domain.services


import retrofit2.Response
import retrofit2.http.GET
import uz.otamurod.domain.model.Booking
import uz.otamurod.domain.model.Hotel
import uz.otamurod.domain.model.Rooms

/**
 * Retrofit API Service
 */

interface ApiService {

    @GET("/v3/35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotel(): Response<Hotel>

    @GET("/v3/f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getHotelRooms(): Response<Rooms>

    @GET("/v3/e8868481-743f-4eb2-a0d7-2bc4012275c8")
    suspend fun getBookingInfo(): Response<Booking>
}