package kittler.matheus.test.di

import kittler.matheus.test.flow.home.HomeViewModel
import kittler.matheus.test.flow.news.NewsViewModel
import kittler.matheus.test.dispatcher.AppDispatchers
import kittler.matheus.test.dispatcher.IAppDispatchers
import kittler.matheus.test.network.module.RetrofitModule
import kittler.matheus.test.network.service.INewsAPI
import kittler.matheus.test.network.service.backend.INewsService
import kittler.matheus.test.network.service.backend.NewsService
import kittler.matheus.test.network.service.mock.IHomeRepository
import kittler.matheus.test.network.service.mock.HomeRepository
import mezzari.torres.lucas.network.source.Network
import mezzari.torres.lucas.network.source.module.client.LogModule
import mezzari.torres.lucas.network.source.module.retrofit.GsonConverterModule
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val genericModule = module {
    single<IAppDispatchers> { AppDispatchers() }
}

val networkModule = module {
    single {
        Network.initialize(
            retrofitLevelModules = arrayListOf(GsonConverterModule(), RetrofitModule()),
            okHttpClientLevelModule = arrayListOf(LogModule())
        )

        return@single Network
    }

    single { get<Network>().build<INewsAPI>("https://gb-mobile-app-teste.s3.amazonaws.com/") }

    single<INewsService> { NewsService(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { NewsViewModel(get(), get()) }
}

val repository = module {
    single<IHomeRepository> {HomeRepository()}
}

val appModule = listOf(genericModule, networkModule, repository, viewModelModule)