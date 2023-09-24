package uz.otamurod.hotelmanagement.di.components

import dagger.BindsInstance
import dagger.Component
import uz.otamurod.hotelmanagement.App
import uz.otamurod.hotelmanagement.di.modules.InteractorModule
import uz.otamurod.hotelmanagement.di.modules.NetworkModule
import uz.otamurod.hotelmanagement.di.modules.RepositoryModule
import uz.otamurod.presentation.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class, InteractorModule::class])
interface ApplicationComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): ApplicationComponent
    }

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}