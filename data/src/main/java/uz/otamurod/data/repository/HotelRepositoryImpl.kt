package uz.otamurod.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.otamurod.data.remote.HotelRemoteDataSource
import uz.otamurod.domain.model.Booking
import uz.otamurod.domain.model.Hotel
import uz.otamurod.domain.model.HotelResponse
import uz.otamurod.domain.model.Rooms
import uz.otamurod.domain.repository.HotelRepository
import javax.inject.Inject

class HotelRepositoryImpl @Inject constructor(
    private val hotelRemoteDataSource: HotelRemoteDataSource
) : uz.otamurod.domain.repository.HotelRepository {

    override suspend fun fetchHotel(): Flow<uz.otamurod.domain.model.HotelResponse<uz.otamurod.domain.model.Hotel>> {
        return flow {
            emit(uz.otamurod.domain.model.HotelResponse.loading())
            val result = hotelRemoteDataSource.fetchHotel()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun fetchHotelRooms(): Flow<uz.otamurod.domain.model.HotelResponse<uz.otamurod.domain.model.Rooms>> {
        return flow {
            emit(uz.otamurod.domain.model.HotelResponse.loading())
            val result = hotelRemoteDataSource.fetchHotelRooms()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun fetchBookingInfo(): Flow<uz.otamurod.domain.model.HotelResponse<uz.otamurod.domain.model.Booking>> {
        return flow {
            emit(uz.otamurod.domain.model.HotelResponse.loading())
            val result = hotelRemoteDataSource.fetchBookingInfo()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}