package uz.otamurod.hotelmanagement.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.otamurod.data.usecase.HotelUseCaseImpl
import uz.otamurod.domain.usecase.HotelUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    @Singleton
    internal abstract fun bindHotelUseCase(hotelUseCaseImpl: HotelUseCaseImpl): HotelUseCase
}