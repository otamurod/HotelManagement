package uz.otamurod.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.otamurod.data.remote.datasource.HotelRemoteDataSource
import uz.otamurod.domain.api.model.Booking
import uz.otamurod.domain.api.model.Hotel
import uz.otamurod.domain.api.model.Rooms
import uz.otamurod.domain.api.repository.HotelRepositoryApi
import uz.otamurod.domain.util.DataState
import javax.inject.Inject

class HotelRepository @Inject constructor(
    private val hotelRemoteDataSource: HotelRemoteDataSource
) : HotelRepositoryApi {

    override suspend fun fetchHotel(): Flow<DataState<Hotel>> {
        return flow {
            emit(DataState.loading())
            val result = hotelRemoteDataSource.fetchHotel()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun fetchHotelRooms(): Flow<DataState<Rooms>> {
        return flow {
            emit(DataState.loading())
            val result = hotelRemoteDataSource.fetchHotelRooms()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun fetchBookingInfo(): Flow<DataState<Booking>> {
        return flow {
            emit(DataState.loading())
            val result = hotelRemoteDataSource.fetchBookingInfo()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}