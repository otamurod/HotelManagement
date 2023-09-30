package uz.otamurod.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.otamurod.data.remote.datasource.HotelRemoteDataSource
import uz.otamurod.domain.api.repository.HotelRepositoryApi
import uz.otamurod.domain.model.Booking
import uz.otamurod.domain.model.Hotel
import uz.otamurod.domain.model.Rooms
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
        }
    }

    override suspend fun fetchHotelRooms(): Flow<DataState<Rooms>> {
        return flow {
            emit(DataState.loading())
            val result = hotelRemoteDataSource.fetchHotelRooms()
            emit(result)
        }
    }

    override suspend fun fetchBookingInfo(): Flow<DataState<Booking>> {
        return flow {
            emit(DataState.loading())
            val result = hotelRemoteDataSource.fetchBookingInfo()
            emit(result)
        }
    }
}