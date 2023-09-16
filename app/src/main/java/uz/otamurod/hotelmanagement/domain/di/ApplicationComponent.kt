package uz.otamurod.hotelmanagement.domain.di

import dagger.BindsInstance
import dagger.Component
import uz.otamurod.hotelmanagement.App
import uz.otamurod.presentation.ui.main.MainActivity
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