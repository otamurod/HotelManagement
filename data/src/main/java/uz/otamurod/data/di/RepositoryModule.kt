package uz.otamurod.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.otamurod.data.repository.HotelRepositoryImpl
import uz.otamurod.domain.repository.HotelRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    internal abstract fun bindHotelRepository(hotelRepositoryImpl: HotelRepositoryImpl): uz.otamurod.domain.repository.HotelRepository
}