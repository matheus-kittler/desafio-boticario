package kittler.matheus.test.network.module

import kittler.matheus.test.network.responseAdapter.RetrofitCallAdapterFactory
import mezzari.torres.lucas.network.source.Network
import retrofit2.Retrofit

class RetrofitModule: Network.RetrofitLevelModule {
    override fun onRetrofitBuilderCreated(retrofitBuilder: Retrofit.Builder) {
        retrofitBuilder.addCallAdapterFactory(RetrofitCallAdapterFactory())
    }
}
