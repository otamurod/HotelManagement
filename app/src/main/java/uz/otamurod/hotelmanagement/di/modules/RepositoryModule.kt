package uz.otamurod.hotelmanagement.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.otamurod.data.repository.HotelRepository
import uz.otamurod.domain.api.repository.HotelRepositoryApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    internal abstract fun bindHotelRepository(hotelRepository: HotelRepository): HotelRepositoryApi
}