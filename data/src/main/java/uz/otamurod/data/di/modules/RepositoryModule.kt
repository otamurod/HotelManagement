package uz.otamurod.data.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.otamurod.data.repository.HotelRepository
import uz.otamurod.domain.api.repository.HotelRepositoryApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideHotelRepository(hotelRepository: HotelRepository): HotelRepositoryApi {
        return hotelRepository
    }
}