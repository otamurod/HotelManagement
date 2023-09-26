package uz.otamurod.hotelmanagement.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.otamurod.data.interactor.HotelInteractor
import uz.otamurod.domain.interactor.HotelInteractorApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorModule {
    @Provides
    @Singleton
    fun provideHotelInteractor(hotelInteractor: HotelInteractor): HotelInteractorApi {
        return hotelInteractor
    }
}