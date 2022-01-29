package shyam.gunsariya.storydigital.module

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import shyam.gunsariya.storydigital.data.api.ApiClient
import shyam.gunsariya.storydigital.data.apprepository.HomeFragRepository
import shyam.gunsariya.storydigital.data.apprepository.HomeFragRepositoryImpl
import shyam.gunsariya.storydigital.data.repository.HomeRepository
import shyam.gunsariya.storydigital.ui.main.viewmodel.HomeFragmentViewModel

//koin dependency injection
val networkModule = module {
    single { ApiClient.getClient() }
}

val viewModelModule = module {
    viewModel{ HomeFragmentViewModel(repository = get())}
}

val repositoryModule = module {
    single { HomeFragRepository(apiService = get()) }
    single<HomeRepository> { HomeFragRepositoryImpl(get()) }
}