package uz.otamurod.hotelmanagement.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.otamurod.data.interactor.HotelInteractor
import uz.otamurod.domain.interactor.HotelInteractorApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InteractorModule {
    @Binds
    @Singleton
    internal abstract fun bindHotelInteractor(hotelInteractor: HotelInteractor): HotelInteractorApi
}