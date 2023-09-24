package uz.otamurod.hotelmanagement.di.components

import dagger.BindsInstance
import dagger.Component
import uz.otamurod.data.di.NetworkModule
import uz.otamurod.data.di.RepositoryModule
import uz.otamurod.domain.di.UseCaseModule
import uz.otamurod.hotelmanagement.App
import uz.otamurod.hotelmanagement.domain.di.RepositoryModule
import uz.otamurod.hotelmanagement.domain.di.UseCaseModule
import uz.otamurod.hotelmanagement.ui.App
import uz.otamurod.hotelmanagement.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class, UseCaseModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): ApplicationComponent
    }

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}